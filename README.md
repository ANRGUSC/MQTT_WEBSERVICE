# A wrapper web-service to publish/subscribe data to MQTT.


---------------
<br>Q) Why should I use this web-service?
<br>Want to get rid of all the mqtt connections and callbacks handling from your application? If yes, simply use the exposed apis to publish or subscribe/unsubscribe to your topic and you are done!
The web-service will establish a connection with the mqtt broker on your behalf and publish/subscribe to your topic for you.
Thus, your application does what it is supposed to do and all the mqtt part is extracted. For eg, your application running on raspberry pi can publish data to the topic via web-service without itself estalishing connections. 
---------------
Q) How to use this service?
<br>It is a Spring Boot application and the final executable is .jar file. 

Requirements:
Java - 1.8
<br>Redis

Steps to run the web-service:
1) Clone the master branch into your local machine.
2) Run the project as a Maven build. 
Command : mvn clean install
3) Look for the .jar file in the target folder of the project. 
4) Copy the .jar file to a particular(for deployment) folder.
5) You can have application.properties in the same folder where you placed your .jar to override default properties. Refer https://docs.spring.io/spring-boot/docs/current/reference/html/boot-features-external-config.html for more details.
6) Execute the .jar file.
   Command:java -jar mqtt.jar
Note: Run the command in background to keep it running even if you log out of the computer.

Getting started with development:

Requirements:
IDE- preferred Eclipse with Spring boot plugin and maven build support or STS.

1) Clone the master branch into your local machine.
2) Import in your ide.
3) Run MqttWebServiceApplication.java as java application. Wait for successfull completion.
---------------
Q) Apis?
1) If your application wants to publish data, make a GET/POST call
<br>Sample GET:
https://localhost:8443/mqtt/publish?message=hey%20Vis&topic=/rth/beacons/
<br>where, message: message you want to publish
       topic  : name of the topic to which you want to publish.
<br>Response:{"published":true}

Note: This will publish data to the broker configured in https://github.com/ANRGUSC/MQTT_WEBSERVICE/blob/master/src/main/resources/application.properties.

2) If you want to subscribe to the topic
<br>Sample GET:
https://localhost:8443/mqtt/subscribe?callbackUrl=http%3A%2F%2Fgoogle.usc.edu%3A8084&topic=/rth/beacons/
<br>where, callbackUrl: rest endpoint where you will receive messages from the topic
       topic  : name of the topic you want to subscribe.
<br>Response:{"subscribed":true}
---------------

2) If you want to unsubscribe to the topic
<br>Sample GET:
https://localhost:8443/mqtt/unsubscribe?topic=/rth/beacons/
<br>where, topic  : name of the topic you want to unsubscribe.
<br>Response:{"unsubscribed":true}
---------------

License-https://github.com/ANRGUSC/MQTT_WEBSERVICE/blob/master/License.md
---------------
Drop me an email at rahane@usc.edu if you need any other info.

