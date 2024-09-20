# 5. Выложить историю команд в терминале ubuntu:

### Задание 1:
```
vika@db-linux:~$ mkdir Animals
vika@db-linux:~$ cd ~/Animals
vika@db-linux:~/Animals$ cat > home_animals
vika@db-linux:~/Animals$ cat home_animals
vika@db-linux:~/Animals$ cat > pack_animals
vika@db-linux:~/Animals$ cat pack_animals
vika@db-linux:~/Animals$ cat home_animals pack_animals > mans_friends
vika@db-linux:~/Animals$ cat mans_friends
vika@db-linux:~/Animals$ ls -ali
```
### Задание 2:
```
vika@db-linux:~/Animals$ mkdir Home_Animals_list
vika@db-linux:~/Animals$ ls
vika@db-linux:~/Animals$ cd Home_Animals_list/
vika@db-linux:~/Animals/Home_Animals_list$ cd ..
vika@db-linux:~/Animals$ mv mans_friends Home_Animals_list/
vika@db-linux:~/Animals$ cd Home_Animals_list/
vika@db-linux:~/Animals/Home_Animals_list$ ls
```
### Задание 3:
```
vika@db-linux:~$ sudo add-apt-repository 'deb http://repo.mysql.com/apt/debian buster mysql-8.0'
vika@db-linux:~$ wget https://repo.mysql.com/RPM-GPG-KEY-mysql
vika@db-linux:~$ sudo mv RPM-GPG-KEY-mysql /etc/apt/trusted.gpg.d/
vika@db-linux:~$ sudo apt update
vika@db-linux:~$ sudo apt-key adv --keyserver keyserver.ubuntu.com --recv-keys B7B3B788A8D3785C
vika@db-linux:~$ sudo apt update
```
### Задание 4:
```
vika@db-linux:~$ sudo wget https://download.docker.com/linux/ubuntu/dists/jammy/pool/stable/amd64/docker-ce-cli_20.10.13~3-0~ubuntu-jammy_amd64.deb
vika@db-linux:~$ sudo dpkg -i docker-ce-cli_20.10.13~3-0~ubuntu-jammy_amd64.deb
vika@db-linux:~$ sudo dpkg --force-depends -r docker-ce-cli
```