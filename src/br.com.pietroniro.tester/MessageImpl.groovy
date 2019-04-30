package br.com.pietroniro.tester
// https://mvnrepository.com/artifact/org.apache.camel/camel-core
@Grapes([
        @Grab(group='org.apache.camel', module='camel-core', version='2.23.2'),
])

import com.sap.gateway.ip.core.customdev.util.AttachmentWrapper
import com.sap.gateway.ip.core.customdev.util.Message
import javax.activation.DataHandler

class MessageImpl implements Message{
    def body = ''
    def headers = [:]
    def properties = [:]

    @Override
    Object getBody() {
        body
    }
    @Override
    void setBody(Object o) {
        this.body = o.toString()
    }

    @Override
    Map<String, Object> getHeaders() {
        headers
    }
    @Override
    def <T> T getHeader(String s, Class<T> aClass) {
        headers.(s)
    }
    @Override
    void setHeaders(Map<String, Object> map) {
        map.each {k, v -> headers.put(k, v)}
    }
    @Override
    void setHeader(String s, Object o) {
        headers << [(s):o]
    }

    @Override
    Map<String, Object> getProperties() {
        properties
    }
    @Override
    void setProperties(Map<String, Object> map) {
        map.each {key, value -> properties.put(key, value)}
    }
    void setProperty(String key, Object value){
        properties.put(key, value)
    }

    @Override
    long getBodySize() {
        body.length()
    }

    @Override
    def <T> T getBody(Class<T> aClass) { }
    @Override
    Map<String, DataHandler> getAttachments() { }
    @Override
    void setAttachments(Map<String, DataHandler> map) { }
    @Override
    long getAttachmentsSize() { }
    @Override
    void addAttachmentHeader(String s, String s1, AttachmentWrapper attachmentWrapper) { }
    @Override
    void setAttachmentHeader(String s, String s1, AttachmentWrapper attachmentWrapper) { }
    @Override
    String getAttachmentHeader(String s, AttachmentWrapper attachmentWrapper) { }
    @Override
    void removeAttachmentHeader(String s, AttachmentWrapper attachmentWrapper) { }
    @Override
    Map<String, AttachmentWrapper> getAttachmentWrapperObjects() { }
    @Override
    void setAttachmentWrapperObjects(Map<String, AttachmentWrapper> map) { }
    @Override
    void addAttachmentObject(String s, AttachmentWrapper attachmentWrapper) { }
    @Override
    void addAttachmentHeader(String s, String s1, org.apache.camel.Attachment attachment) { }
    @Override
    void setAttachmentHeader(String s, String s1, org.apache.camel.Attachment attachment) { }
    @Override
    String getAttachmentHeader(String s, org.apache.camel.Attachment attachment) { }
    @Override
    void removeAttachmentHeader(String s, org.apache.camel.Attachment attachment) { }
    @Override
    Map<String, org.apache.camel.Attachment> getAttachmentObjects() { }
    @Override
    void setAttachmentObjects(Map<String, org.apache.camel.Attachment> map) { }
    @Override
    void addAttachmentObject(String s, org.apache.camel.Attachment attachment) { }
}
