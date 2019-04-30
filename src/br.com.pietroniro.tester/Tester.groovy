/***
 * Script that simulates the SAP CPI
 */
package br.com.pietroniro.tester

@Grapes(
        @Grab(group='org.slf4j', module='slf4j-simple', version='1.7.26')
)

import com.sap.gateway.ip.core.customdev.util.Message

//Load Groovy Script
def path = getClass().protectionDomain.codeSource.location.path
//        .replace("/testing/Tester.groovy", "/hmac/HMacSigner.groovy")
def shell = new GroovyShell()
def script = shell.parse(new File("Script1.groovy"))
//def script = shell.parse(new File(path))

//Initialize message with body, header and property
Message msg = new MessageImpl()
//msg.setBody(new String('Hello Groovy World'))
//msg.setProperty("oldProperty", "MyGroovyProperty")

msg.setHeader('Content-Type', 'application/json')


//Execute script
script.processData(msg)

//Display results of script in console
println("***BODY*** \n${msg.getBody()}\n")

def displayMaps = { String mapName, Map map ->
    println "***${mapName.toUpperCase()}***"
    map.each{ key, value -> println "${key} = ${value}"}
    println()
}

displayMaps("Headers:", msg.getHeaders())
displayMaps("Properties:", msg.getProperties())