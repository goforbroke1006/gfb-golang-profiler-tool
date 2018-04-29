# gfb-golang-tool

Plugin for Intellij IDEA.

Requirements:

* Intellij IDEA 2016
* Java 1.8


Install JDK 1.8 on Centos

    $ wget --no-cookies --no-check-certificate --header "Cookie: gpw_e24=http%3A%2F%2Fwww.oracle.com%2F; oraclelicense=accept-securebackup-cookie" "http://download.oracle.com/otn-pub/java/jdk/8u141-b15/336fa29ff2bb4ef291e347e091f7f4a7/jdk-8u141-linux-i586.tar.gz"
    $ tar xzf jdk-8u141-linux-i586.tar.gz
    $ alternatives --install /usr/bin/java java /opt/jdk1.8.0_141/bin/java 2
    $ alternatives --config java