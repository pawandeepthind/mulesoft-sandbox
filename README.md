# README

## What

Machine setup for API Implementation.

*API:* Find In Store API

*Description:* Allows finding inventory of items in nearby stores. This application contains two components

  1. _API implementation:_ Find location(lat,lng) using Google Geocode API for the provided address. And then uses this location(lat,lng) to lookup nearby stores in database table stored in db. And then lookup inventory for the items in the request for these nearby stores (limited to 5) and respond back with result.

  2. _Supporting Integration:_ This integration
      1. Is used to load inventory in storeitemqty table. This can be setup as full sync once a day.
      2. Is used to load store in store table. (not required just using it for ease of setup)

## Steps to setup the application

1. Here are some of the pre-requisite (Note: It is tested on Mac OS X for now)
* Install latest virtual Box (5.2.12-122591 - VirtualBox-5.2.12-122591-OSX.dmg)
* Install Vagrant (2.1.2 - vagrant_2.1.2_x86_64.dmg)
* Install plugins (vbguest and hostmanager)

```
$ vagrant plugin install vagrant-hostmanager
$ vagrant plugin install vagrant-vbguest
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

  ```http
  POST /api/findinstore HTTP/1.1
  Host: localhost:8081
  Content-Type: application/json
  Cache-Control: no-cache

  {
    "address": "49 W 27th St New York NY 10001",
    "itemids": [
      "10001",
      "10002"
    ]
  }
  ```

  Find the Postman collection link [here](FindInStoreDemo.postman_collection.json) for details on how to call API

### Connectivity Information for MySql and SFTP (in case required)

* MySql DB:

| Property | Values      |
| -------- | ----------- |
| host     | 10.0.20.20  |
| port     | 3306        |
| user     | root        |
| password | password    |
| dbname   | inventory   |

* SFTP:

| Property |  Values              |
| -------- | -------------------- |
| host     | 10.0.20.20           |
| port     | 22                   |
| user     | vagrant              |
| password | vagrant              |
| home dir | /home/vagrant        |

### Note: SQL statement used to find 5 nearby stores, this query is taken from the following discussion [link](https://gis.stackexchange.com/questions/31628/find-points-within-a-distance-using-mysql)

```sql
SELECT
  id, (
    3959 * acos (
      cos ( radians(78.3232) )
      * cos( radians( lat ) )
      * cos( radians( lng ) - radians(65.3234) )
      + sin ( radians(78.3232) )
      * sin( radians( lat ) )
    )
  ) AS distance
FROM markers
ORDER BY distance
LIMIT 0 , 5;
```