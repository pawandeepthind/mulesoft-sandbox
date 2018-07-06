# What
Dev machine for Mulesoft API presentation 

# How
## 1. Install Pre-requisite:
It is good to read about Vagrant and Ansible.

## Here are some of the pre-requisite (Note: It is tested on Mac OS X for now)
  * Install latest vagrant
  * Install latest Virtual Box
  * Install plugins (vbguest and hostmanager)
    
  ```
  $ vagrant plugin install vagrant-vbguest
  $ vagrant plugin install vagrant-hostmanager
  ```

1. Checkout the code from git repository
  
  ```
  $ git clone https://github.com/pawandeepthind/mulesoft-sandbox.git
  ```
    
2. Change directory to mulesoft-sandbox/sandbox

  ```
  $ git clone mulesoft-sandbox/sandbox
  ```

3. Execute vagrant up command
    ```
    vagrant up
    ```
4. Once the machine

2. **Links, Credentials and Ports** (Note: ip can be different depending on the ip used in config.yml)
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

   
