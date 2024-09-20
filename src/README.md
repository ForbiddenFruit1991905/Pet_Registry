# Итоговая контрольная работа

### Информация о проекте

Необходимо организовать систему учета для питомника в котором живут
домашние и вьючные животные.

### Задание
1. Используя команду cat в терминале операционной системы Linux, создать
   два файла Домашние животные (заполнив файл собаками, кошками,
   хомяками) и Вьючные животными заполнив файл Лошадьми, верблюдами и
   ослы), а затем объединить их. Просмотреть содержимое созданного файла.
   Переименовать файл, дав ему новое имя (Друзья человека).
   ```
   vika@db-linux:~$ mkdir Animals
   vika@db-linux:~$ cd ~/Animals
   vika@db-linux:~/Animals$ cat > home_animals
   dogs, cats & hamsters
   vika@db-linux:~/Animals$ cat home_animals
   dogs, cats & hamsters
   vika@db-linux:~/Animals$ cat > pack_animals
   horses, camels & donkeys
   vika@db-linux:~/Animals$ cat pack_animals
   horses, camels & donkeys
   vika@db-linux:~/Animals$ cat home_animals pack_animals > mans_friends
   vika@db-linux:~/Animals$ cat mans_friends
   dogs, cats & hamsters
   horses, camels & donkeys
   vika@db-linux:~/Animals$ ls -ali
   итого 20
   491725 drwxrwxr-x  2 vika vika 4096 сен  1 16:16 .
   441629 drwxr-x--- 30 vika vika 4096 сен  1 16:00 ..
   412066 -rw-rw-r--  1 vika vika   22 сен  1 16:04 home_animals
   413432 -rw-rw-r--  1 vika vika   47 сен  1 16:09 mans_friends
   413430 -rw-rw-r--  1 vika vika   25 сен  1 16:07 pack_animals
   ```
2. Создать директорию, переместить файл туда.
   ```
   vika@db-linux:~/Animals$ mkdir Home_Animals_list
   vika@db-linux:~/Animals$ ls
   home_animals  Home_Animals_list  mans_friends  pack_animals
   vika@db-linux:~/Animals$ cd Home_Animals_list/
   vika@db-linux:~/Animals/Home_Animals_list$ cd ..
   vika@db-linux:~/Animals$ mv mans_friends Home_Animals_list/
   vika@db-linux:~/Animals$ cd Home_Animals_list/
   vika@db-linux:~/Animals/Home_Animals_list$ ls
   mans_friends
   ```
3. Подключить дополнительный репозиторий MySQL. Установить любой пакет
   из этого репозитория.
   ```    
   vika@db-linux:~$ sudo add-apt-repository 'deb http://repo.mysql.com/apt/debian buster mysql-8.0'
   Репозиторий: 'deb http://repo.mysql.com/apt/debian buster mysql-8.0'
   Описание:
   Archive for codename: buster components: mysql-8.0
   Дополнительные сведения: http://repo.mysql.com/apt/debian
   Добавление репозитория.
   Нажмите [ENTER] для продолжения или Ctrl-C для отмены.
   Found existing deb entry in /etc/apt/sources.list.d/archive_uri-http_repo_mysql_com_apt_debian-jammy.list
   Adding deb entry to /etc/apt/sources.list.d/archive_uri-http_repo_mysql_com_apt_debian-jammy.list
   Found existing deb-src entry in /etc/apt/sources.list.d/archive_uri-http_repo_mysql_com_apt_debian-jammy.list
   Adding disabled deb-src entry to /etc/apt/sources.list.d/archive_uri-http_repo_mysql_com_apt_debian-jammy.list
   Сущ:1 http://ru.archive.ubuntu.com/ubuntu jammy InRelease     
   Сущ:2 http://ru.archive.ubuntu.com/ubuntu jammy-updates InRelease
   Сущ:3 http://ru.archive.ubuntu.com/ubuntu jammy-backports InRelease  
   Пол:4 http://repo.mysql.com/apt/debian buster InRelease [22,1 kB]     
   Сущ:5 https://download.docker.com/linux/ubuntu jammy InRelease         
   Сущ:6 http://security.ubuntu.com/ubuntu jammy-security InRelease    
   Сущ:7 https://download.virtualbox.org/virtualbox/debian jammy InRelease
   Ошб:4 http://repo.mysql.com/apt/debian buster InRelease        
   Следующие подписи не могут быть проверены, так как недоступен открытый ключ: NO_PUBKEY B7B3B788A8D3785C
   Чтение списков пакетов… Готово
   W: Ошибка GPG: http://repo.mysql.com/apt/debian buster InRelease: Следующие подписи не могут быть проверены, так как недоступен открытый ключ: NO_PUBKEY B7B3B788A8D3785C
   E: Репозиторий «http://repo.mysql.com/apt/debian buster InRelease» не подписан.
   N: Обновление из этого репозитория нельзя выполнить безопасным способом, поэтому по умолчанию он отключён.
   N: Информацию о создании репозитория и настройках пользователя смотрите в справочной странице apt-secure(8).
   vika@db-linux:~$ wget https://repo.mysql.com/RPM-GPG-KEY-mysql
   --2024-09-01 17:04:12--  https://repo.mysql.com/RPM-GPG-KEY-mysql
   Распознаётся repo.mysql.com (repo.mysql.com)… 23.2.222.159, 2a02:26f0:d200:893::1d68, 2a02:26f0:d200:888::1d68
   Подключение к repo.mysql.com (repo.mysql.com)|23.2.222.159|:443... соединение установлено.
   HTTP-запрос отправлен. Ожидание ответа… 200 OK
   Длина: 1944 (1,9K) [text/plain]
   Сохранение в: ‘RPM-GPG-KEY-mysql’
   RPM-GPG-KEY-mysql                  100%[================================================================>]   1,90K  --.-KB/s    за 0s      
   2024-09-01 17:04:13 (595 MB/s) - ‘RPM-GPG-KEY-mysql’ сохранён [1944/1944]
   vika@db-linux:~$ sudo mv RPM-GPG-KEY-mysql /etc/apt/trusted.gpg.d/
   vika@db-linux:~$ sudo apt update
   Сущ:1 http://ru.archive.ubuntu.com/ubuntu jammy InRelease
   Сущ:2 http://ru.archive.ubuntu.com/ubuntu jammy-updates InRelease   
   Сущ:3 http://ru.archive.ubuntu.com/ubuntu jammy-backports InRelease 
   Сущ:4 http://security.ubuntu.com/ubuntu jammy-security InRelease    
   Сущ:5 https://download.virtualbox.org/virtualbox/debian jammy InRelease
   Сущ:6 https://download.docker.com/linux/ubuntu jammy InRelease 
   Пол:7 http://repo.mysql.com/apt/debian buster InRelease [22,1 kB]
   Ошб:7 http://repo.mysql.com/apt/debian buster InRelease
   Следующие подписи не могут быть проверены, так как недоступен открытый ключ: NO_PUBKEY B7B3B788A8D3785C
   Чтение списков пакетов… Готово
   W: Ошибка GPG: http://repo.mysql.com/apt/debian buster InRelease: Следующие подписи не могут быть проверены, так как недоступен открытый ключ: NO_PUBKEY B7B3B788A8D3785C
   E: Репозиторий «http://repo.mysql.com/apt/debian buster InRelease» не подписан.
   N: Обновление из этого репозитория нельзя выполнить безопасным способом, поэтому по умолчанию он отключён.
   N: Информацию о создании репозитория и настройках пользователя смотрите в справочной странице apt-secure(8).
   vika@db-linux:~$ sudo apt-key adv --keyserver keyserver.ubuntu.com --recv-keys B7B3B788A8D3785C
   Warning: apt-key is deprecated. Manage keyring files in trusted.gpg.d instead (see apt-key(8)).
   Executing: /tmp/apt-key-gpghome.nVPABXduNF/gpg.1.sh --keyserver keyserver.ubuntu.com --recv-keys B7B3B788A8D3785C
   gpg: ключ B7B3B788A8D3785C: импортирован открытый ключ "MySQL Release Engineering <mysql-build@oss.oracle.com>"
   gpg: Всего обработано: 1
   gpg:               импортировано: 1
   vika@db-linux:~$ sudo apt update
   Сущ:1 http://ru.archive.ubuntu.com/ubuntu jammy InRelease
   Сущ:2 http://ru.archive.ubuntu.com/ubuntu jammy-updates InRelease   
   Сущ:3 http://ru.archive.ubuntu.com/ubuntu jammy-backports InRelease  
   Пол:4 http://repo.mysql.com/apt/debian buster InRelease [22,1 kB]    
   Сущ:5 http://security.ubuntu.com/ubuntu jammy-security InRelease     
   Сущ:6 https://download.docker.com/linux/ubuntu jammy InRelease    
   Сущ:7 https://download.virtualbox.org/virtualbox/debian jammy InRelease
   Пол:8 http://repo.mysql.com/apt/debian buster/mysql-8.0 amd64 Packages [8?610 B]
   Получено 30,7 kB за 2с (17,1 kB/s)     
   Чтение списков пакетов… Готово
   Построение дерева зависимостей… Готово
   Чтение информации о состоянии… Готово     
   Может быть обновлено 5 пакетов. Запустите «apt list --upgradable» для их показа.
   W: http://repo.mysql.com/apt/debian/dists/buster/InRelease: Ключ хранится в унаследованной связке ключей trusted.gpg (/etc/apt/trusted.gpg), подробности см. в разделе DEPRECATION в apt-key(8).
   ```
4. Установить и удалить deb-пакет с помощью dpkg.
   ```
   vika@db-linux:~$ sudo wget https://download.docker.com/linux/ubuntu/dists/jammy/pool/stable/amd64/docker-ce-cli_20.10.13~3-0~ubuntu-jammy_amd64.deb
   --2024-09-01 17:19:54--  https://download.docker.com/linux/ubuntu/dists/jammy/pool/stable/amd64/docker-ce-cli_20.10.13~3-0~ubuntu-jammy_amd64.deb
   Распознаётся download.docker.com (download.docker.com)… 3.164.206.102, 3.164.206.93, 3.164.206.5, ...
   Подключение к download.docker.com (download.docker.com)|3.164.206.102|:443... соединение установлено.
   HTTP-запрос отправлен. Ожидание ответа… 200 OK
   Длина: 40955778 (39M) [binary/octet-stream]
   Сохранение в: ‘docker-ce-cli_20.10.13~3-0~ubuntu-jammy_amd64.deb’
   docker-ce-cli_20.10.13~3-0~ubuntu- 100%[================================================================>]  39,06M  5,85MB/s    за 7,4s    
   2024-09-01 17:20:02 (5,30 MB/s) - ‘docker-ce-cli_20.10.13~3-0~ubuntu-jammy_amd64.deb’ сохранён [40955778/40955778]
   vika@db-linux:~$ sudo dpkg -i docker-ce-cli_20.10.13~3-0~ubuntu-jammy_amd64.deb
   dpkg: предупреждение: снижение версии docker-ce-cli с 5:27.2.0-1~ubuntu.22.04~jammy до 5:20.10.13~3-0~ubuntu-jammy
   (Чтение базы данных … на данный момент установлено 202154 файла и каталога.)
   Подготовка к распаковке docker-ce-cli_20.10.13~3-0~ubuntu-jammy_amd64.deb …
   Распаковывается docker-ce-cli (5:20.10.13~3-0~ubuntu-jammy) на замену (5:27.2.0-1~ubuntu.22.04~jammy) …
   Заменено файлами из установленного пакета docker-buildx-plugin (0.16.2-1~ubuntu.22.04~jammy) …
   Настраивается пакет docker-ce-cli (5:20.10.13~3-0~ubuntu-jammy) …
   Обрабатываются триггеры для man-db (2.10.2-1) …
   vika@db-linux:~$ sudo dpkg --force-depends -r docker-ce-cli
   dpkg: docker-ce-cli: имеются проблемы с зависимостями, но по вашему указанию
   он всё равно будет удалён:
   docker-ce зависит от docker-ce-cli.
   (Чтение базы данных … на данный момент установлено 202152 файла и каталога.)
   Удаляется docker-ce-cli (5:20.10.13~3-0~ubuntu-jammy) …
   Обрабатываются триггеры для man-db (2.10.2-1) …
   ```
5. Выложить историю команд в терминале ubuntu.
[UbuntuHistory](https://github.com/ForbiddenFruit1991905/Pet_Registry/blob/main/src/UbuntuHistory.md)
6. Нарисовать [диаграмму](), в которой есть класс родительский класс, домашние животные и вьючные животные, в составы которых в случае домашних
животных войдут классы: собаки, кошки, хомяки, а в класс вьючные животные
войдут: Лошади, верблюды и ослы).