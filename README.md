# README
---

# What
Dev machine setup for Mulesoft API presentation. This machine will host the mysql database and SFTP server.

# Steps

## 1. Here are some of the pre-requisite (Note: It is tested on Mac OS X for now)
  * Install latest vagrant
  * Install latest virtual Box
  * Install plugins (vbguest and hostmanager)
    
  ```
  $ vagrant plugin install vagrant-vbguest
  $ vagrant plugin install vagrant-hostmanager
  ```

## 2. Checkout the code

  ```
  $ git clone https://github.com/pawandeepthind/mulesoft-sandbox.git
  ```
    
## 3. Change directory to mulesoft-sandbox/sandbox

  ```
  $ git clone mulesoft-sandbox/sandbox
  ```

## 4. Execute vagrant up command (Note: This command may take some time for the first time, 10-15 mins)

  ```
  $ vagrant up
  ```

##4. Import inventory project to anypoint studio using mulesoft-sandbox/inventory/pom.xml

## 5. Right click on the imported inventory project and run, validate in console that application is deployed successfully

## 6. Call API using following specification


## Connectivity Information to the vagrant dev box (in case required)
. **Links, Credentials and Ports** (Note: ip can be different depending on the ip used in config.yml)
   * MySql DB: 
      host: 10.0.20.20
      port: 3306
      user: root
      password: password
      dbname: inventory
   * SFTP
      host: 10.0.20.20
      port: 22
      username: vagrant
      password: vagrant
      path: /home/vagrant/sftp

   

