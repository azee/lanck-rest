
package com.lanctele.rest;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for User complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="User">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="externalService" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="nameFull" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="balance" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="externalId" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="acceptCalls" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="photo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="phoneNumber" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="gender" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "User", propOrder = {
    "externalService",
    "nameFull",
    "balance",
    "externalId",
    "acceptCalls",
    "photo",
    "phoneNumber",
    "gender"
})
@XmlRootElement(name = "user")
public class User
    implements Serializable
{

    @XmlElement(required = true)
    protected String externalService;
    @XmlElement(required = true)
    protected String nameFull;
    @XmlElement(required = true)
    protected String balance;
    protected float externalId;
    protected boolean acceptCalls;
    @XmlElement(required = true)
    protected String photo;
    @XmlElement(required = true)
    protected String phoneNumber;
    @XmlElement(required = true)
    protected String gender;

    /**
     * Gets the value of the externalService property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExternalService() {
        return externalService;
    }

    /**
     * Sets the value of the externalService property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExternalService(String value) {
        this.externalService = value;
    }

    /**
     * Gets the value of the nameFull property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNameFull() {
        return nameFull;
    }

    /**
     * Sets the value of the nameFull property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNameFull(String value) {
        this.nameFull = value;
    }

    /**
     * Gets the value of the balance property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBalance() {
        return balance;
    }

    /**
     * Sets the value of the balance property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBalance(String value) {
        this.balance = value;
    }

    /**
     * Gets the value of the externalId property.
     * 
     */
    public float getExternalId() {
        return externalId;
    }

    /**
     * Sets the value of the externalId property.
     * 
     */
    public void setExternalId(float value) {
        this.externalId = value;
    }

    /**
     * Gets the value of the acceptCalls property.
     * 
     */
    public boolean isAcceptCalls() {
        return acceptCalls;
    }

    /**
     * Sets the value of the acceptCalls property.
     * 
     */
    public void setAcceptCalls(boolean value) {
        this.acceptCalls = value;
    }

    /**
     * Gets the value of the photo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPhoto() {
        return photo;
    }

    /**
     * Sets the value of the photo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPhoto(String value) {
        this.photo = value;
    }

    /**
     * Gets the value of the phoneNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Sets the value of the phoneNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPhoneNumber(String value) {
        this.phoneNumber = value;
    }

    /**
     * Gets the value of the gender property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGender() {
        return gender;
    }

    /**
     * Sets the value of the gender property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGender(String value) {
        this.gender = value;
    }

}
