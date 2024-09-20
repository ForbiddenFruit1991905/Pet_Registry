-- 7. В подключенном MySQL репозитории создать базу данных “Друзья человека”

# CREATE DATABASE Human_friends;

-- 8. Создать таблицы с иерархией из диаграммы в БД

USE Human_friends;
CREATE TABLE animals_classes
(
	Id INT AUTO_INCREMENT PRIMARY KEY, 
	main_classes VARCHAR(20)
);

INSERT INTO animals_classes (main_classes)
VALUES ('packed_animals'), ('home_animals');  

CREATE TABLE packed_animals
(
	Id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR (20),
    Class_id INT,
    FOREIGN KEY (Class_id) REFERENCES animals_classes (Id) ON DELETE CASCADE ON UPDATE CASCADE
);

INSERT INTO packed_animals (name, Class_id)
VALUES ('Лошади', 1), ('Верблюды', 1), ('Ослы', 1); 
    
CREATE TABLE home_animals
(
	Id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR (20),
    Class_id INT,
    FOREIGN KEY (Class_id) REFERENCES animals_classes (Id) ON DELETE CASCADE ON UPDATE CASCADE
);

INSERT INTO home_animals (name, Class_id)
VALUES ('Кошки', 2), ('Собаки', 2), ('Хомяки', 2); 

-- 9. Заполнить низкоуровневые таблицы именами(животных), командами которые 
-- они выполняют и датами рождения

CREATE TABLE cats 
(       
    Id INT AUTO_INCREMENT PRIMARY KEY, 
    Name VARCHAR(20), 
    Commands VARCHAR(100),
    Birthday DATE,    
    Species_id int,
    Foreign KEY (Species_id) REFERENCES home_animals (Id) ON DELETE CASCADE ON UPDATE CASCADE
); 

INSERT INTO cats (Name, Commands, Birthday, Species_id)
VALUES ('Василиса', 'КОМАНДА1, КОМАНДА2, КОМАНДА3', '2018-05-10', 1),
       ('Мурзик', 'КОМАНДА4, КОМАНДА5, КОМАНДА6', '2019-08-20', 1),
       ('Барсик', 'КОМАНДА7, КОМАНДА8, КОМАНДА9', '2020-03-15', 1); 
       
CREATE TABLE dogs 
(       
    Id INT AUTO_INCREMENT PRIMARY KEY, 
    Name VARCHAR(20), 
    Commands VARCHAR(100),
    Birthday DATE,    
    Species_id int,
    Foreign KEY (Species_id) REFERENCES home_animals (Id) ON DELETE CASCADE ON UPDATE CASCADE
);

INSERT INTO dogs (Name, Commands, Birthday, Species_id)
VALUES ('Шарик', 'КОМАНДА1, КОМАНДА2, КОМАНДА3', '2017-02-28', 2),
       ('Бобик', 'КОМАНДА4, КОМАНДА5, КОМАНДА6', '2018-11-12', 2),
       ('Рекс', 'КОМАНДА7, КОМАНДА8, КОМАНДА9', '2019-06-05', 2);
       
CREATE TABLE hamsters 
(       
    Id INT AUTO_INCREMENT PRIMARY KEY, 
    Name VARCHAR(20), 
    Commands VARCHAR(100),
    Birthday DATE,    
    Species_id int,
    Foreign KEY (Species_id) REFERENCES home_animals (Id) ON DELETE CASCADE ON UPDATE CASCADE
);

INSERT INTO hamsters (Name, Commands, Birthday, Species_id)
VALUES ('Хвостик', 'КОМАНДА1, КОМАНДА2, КОМАНДА3', '2020-01-15', 3),
       ('Буся', 'КОМАНДА4, КОМАНДА5, КОМАНДА6', '2019-10-22', 3),
       ('Трюфель', 'КОМАНДА7, КОМАНДА8, КОМАНДА9', '2018-07-30', 3);
       
CREATE TABLE horses 
(       
    Id INT AUTO_INCREMENT PRIMARY KEY, 
    Name VARCHAR(20), 
    Commands VARCHAR(100),
    Birthday DATE,    
    Species_id int,
    Foreign KEY (Species_id) REFERENCES packed_animals (Id) ON DELETE CASCADE ON UPDATE CASCADE
);

INSERT INTO horses (Name, Commands, Birthday, Species_id)
VALUES ('Граф', 'КОМАНДА1, КОМАНДА2, КОМАНДА3', '2015-04-03', 1),
       ('Лира', 'КОМАНДА4, КОМАНДА5, КОМАНДА6', '2016-09-18',1),
       ('Шторм', 'КОМАНДА7, КОМАНДА8, КОМАНДА9', '2017-12-10', 1);

CREATE TABLE camels 
(       
    Id INT AUTO_INCREMENT PRIMARY KEY, 
    Name VARCHAR(20), 
    Commands VARCHAR(100),
    Birthday DATE,    
    Species_id int,
    Foreign KEY (Species_id) REFERENCES packed_animals (Id) ON DELETE CASCADE ON UPDATE CASCADE
);

INSERT INTO camels (Name, Commands, Birthday, Species_id)
VALUES ('Саид', 'КОМАНДА1, КОМАНДА2, КОМАНДА3', '2014-07-25', 2),
       ('Жасур', 'КОМАНДА4, КОМАНДА5, КОМАНДА6', '2015-10-30', 2),
       ('Махмуд', 'КОМАНДА7, КОМАНДА8, КОМАНДА9', '2016-03-14', 2);

CREATE TABLE donkeys 
(       
    Id INT AUTO_INCREMENT PRIMARY KEY, 
    Name VARCHAR(20), 
    Commands VARCHAR(100),
    Birthday DATE,    
    Species_id int,
    Foreign KEY (Species_id) REFERENCES packed_animals (Id) ON DELETE CASCADE ON UPDATE CASCADE
);

INSERT INTO donkeys (Name, Commands, Birthday, Species_id)
VALUES ('Буран', 'КОМАНДА1, КОМАНДА2, КОМАНДА3', '2019-01-08', 3),
       ('Мулла', 'КОМАНДА4, КОМАНДА5, КОМАНДА6', '2020-06-22', 3),
       ('Азиз', 'КОМАНДА7, КОМАНДА8, КОМАНДА9', '2018-11-05', 3);

-- 10. Удалив из таблицы верблюдов, т.к. верблюдов решили перевезти в другой
-- питомник на зимовку. Объединить таблицы лошади, и ослы в одну таблицу.

SET SQL_SAFE_UPDATES = 0;
DELETE FROM camels;

SELECT Name, Commands, Birthday 
FROM horses
UNION 
SELECT Name, Commands, Birthday 
FROM donkeys;

-- 11.Создать новую таблицу “молодые животные” в которую попадут все
-- животные старше 1 года, но младше 3 лет и в отдельном столбце с точностью
-- до месяца подсчитать возраст животных в новой таблице

CREATE TABLE young_animals
(
    Animal_id INT AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(20),
    Age_in_months INT
    # PRIMARY KEY (Animal_id)
);

INSERT INTO young_animals (Animal_id, Name, Age_in_months)
SELECT a.Id AS Animal_id, 
	   a.Name, 
       ROUND(DATEDIFF(CURDATE(), a.Birthday) / 30) AS Age_in_months       
FROM animals_classes AS ac
JOIN (
    SELECT Id, name, Birthday, Species_id 
    FROM (
        SELECT Id, name, Birthday, Species_id
        FROM cats
        UNION ALL
        SELECT Id, name, Birthday, Species_id
        FROM dogs
        UNION ALL
        SELECT Id, name, Birthday, Species_id
        FROM hamsters
        UNION ALL
        SELECT Id, name, Birthday, Species_id
        FROM horses
        UNION ALL
        SELECT Id, name, Birthday, Species_id
        FROM camels
    ) AS All_animals
) AS a
ON a.Species_id = ac.Id
WHERE DATEDIFF(CURDATE(), a.Birthday) > 365 AND DATEDIFF(CURDATE(), a.Birthday) < 1095
ORDER BY Age_in_months ASC;

select * from young_animals;

-- 12. Объединить все таблицы в одну, при этом сохраняя поля, указывающие на
-- прошлую принадлежность к старым таблицам.

CREATE TABLE all_animals AS
(
    SELECT Id, Name, Commands, Birthday, 'Cat' as AnimalType
    FROM cats
    UNION ALL
    SELECT Id, Name, Commands, Birthday, 'Dog' as AnimalType
    FROM dogs
    UNION ALL
    SELECT Id, Name, Commands, Birthday, 'Hamster' as AnimalType
    FROM hamsters
    UNION ALL
    SELECT Id, Name, Commands, Birthday, 'Horse' as AnimalType
    FROM horses
    UNION ALL
    SELECT Id, Name, Commands, Birthday, 'Camel' as AnimalType
    FROM camels
    UNION ALL
    SELECT Id, Name, Commands, Birthday, 'Donkey' as AnimalType
    FROM donkeys
);

SELECT * FROM all_animals;

