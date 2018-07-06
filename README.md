# README

# What
Dev machine setup for Mulesoft API Implementation. Find In Store API that allows finding inventory of items in nearby stores. 

# Steps

1. Here are some of the pre-requisite (Note: It is tested on Mac OS X for now)
  * Install latest vagrant
  * Install latest virtual Box
  * Install plugins (vbguest and hostmanager)
    
  ```
  $ vagrant plugin install vagrant-vbguest
  $ vagrant plugin install vagrant-hostmanager
  ```

2. Checkout the code

  ```
  $ git clone https://github.com/pawandeepthind/mulesoft-sandbox.git
  ```
    
3. Change directory to mulesoft-sandbox/sandbox

  ```
  $ cd mulesoft-sandbox/sandbox
  ```

4. Execute vagrant up command (Note: This command may take some time for the first time, 10-15 mins)

  ```
  $ vagrant up
  ```

5. Import inventory project to anypoint studio using mulesoft-sandbox/inventory/pom.xml

  ```
  Click File > Import > Maven based Mule project from pom.xml > Select project pom.xml file and import
  ```

6. Right click on the imported inventory project and Validate in console that application is deployed successfully

  ```
  Click on inventory project > Run As > Mule Application with Maven,
  ```

7. Call API using following specification

  ```
  POST /api/findinstore HTTP/1.1
  Host: localhost:8081
  Content-Type: application/json
  Cache-Control: no-cache

  {
    "country": "US",
    "postal_code": "Boston",
    "itemids": [
      "10001",
      "10002"
    ]
  }
  ```

  Find the Postman collection link [here](FindInStoreDemo.postman_collection.json) for details on how to call API

## Connectivity Information to the vagrant dev box (in case required)
. **Links, Credentials and Ports** (Note: ip can be different depending on the ip used in config.yml)
   * MySql DB: 
      | Property | Values      |
      |:-------- |:----------- |
      | host     | 10.0.20.20  |
      | port     | 3306        |
      | user     | root        |
      | password | password    |
      | dbname   | inventory   |

   * SFTP:
      | Property |  Values              |
      |:-------- |:-------------------- |
      | host     | 10.0.20.20           |
      | port     | 22                   |
      | user     | vagrant              |
      | password | vagrant              |
      | dbname   | /home/vagrant/sftp   |
