//
// This file was generated by the Eclipse Implementation of JAXB, v3.0.0 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2022.10.06 at 07:19:09 PM EEST 
//


package ua.lb4.restclient.model.user;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import jakarta.xml.bind.annotation.adapters.CollapsedStringAdapter;
import jakarta.xml.bind.annotation.adapters.NormalizedStringAdapter;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import ua.lb4.restclient.model.Entity;


/**
 * <p>Java class for User complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="User"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://model.lb2.ua.mylaba/}Entity"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="name" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token"&gt;
 *               &lt;minLength value="2"/&gt;
 *               &lt;maxLength value="50"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="surname" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token"&gt;
 *               &lt;minLength value="2"/&gt;
 *               &lt;maxLength value="50"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="addressFrom"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}normalizedString"&gt;
 *               &lt;minLength value="5"/&gt;
 *               &lt;maxLength value="200"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="addressTo"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}normalizedString"&gt;
 *               &lt;minLength value="5"/&gt;
 *               &lt;maxLength value="200"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="answer" type="{http://model.lb2.ua.mylaba/user/}emailOrPhone"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "User", propOrder = {
        "name",
        "surname",
        "addressFrom",
        "addressTo",
        "answer"
})
public class User
        extends Entity {

    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String name;
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String surname;
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String addressFrom;
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String addressTo;
    @XmlElement(required = true)
    protected EmailOrPhone answer;

    /**
     * Gets the value of the name property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the surname property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getSurname() {
        return surname;
    }

    /**
     * Sets the value of the surname property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setSurname(String value) {
        this.surname = value;
    }

    /**
     * Gets the value of the addressFrom property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getAddressFrom() {
        return addressFrom;
    }

    /**
     * Sets the value of the addressFrom property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setAddressFrom(String value) {
        this.addressFrom = value;
    }

    /**
     * Gets the value of the addressTo property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getAddressTo() {
        return addressTo;
    }

    /**
     * Sets the value of the addressTo property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setAddressTo(String value) {
        this.addressTo = value;
    }

    /**
     * Gets the value of the answer property.
     *
     * @return possible object is
     * {@link EmailOrPhone }
     */
    public EmailOrPhone getAnswer() {
        return answer;
    }

    /**
     * Sets the value of the answer property.
     *
     * @param value allowed object is
     *              {@link EmailOrPhone }
     */
    public void setAnswer(EmailOrPhone value) {
        this.answer = value;
    }

    @Override
    public String toString() {
        return "id = " + id + "\tcode = " + code + " {" +
                "name = '" + name + '\'' +
                ", surname = '" + surname + '\'' +
                ", addressFrom = '" + addressFrom + '\'' +
                ", addressTo = '" + addressTo + '\'' +
                "" + answer +
                "}\n";
    }

    private User(int id, String code, String name, String surname, String addressFrom, String addressTo, String str) {
        super(id, code);
        this.answer = new EmailOrPhone(str);
        this.name = name;
        this.surname = surname;
        this.addressFrom = addressFrom;
        this.addressTo = addressTo;
    }

    private User(int id, String code, String addressFrom, String addressTo, String str) {
        super(id, code);
        this.answer = new EmailOrPhone(str);
        this.addressFrom = addressFrom;
        this.addressTo = addressTo;
    }

    private User(int id, String code, String name, String addressFrom, String addressTo, String str) {
        super(id, code);
        this.name = name;
        this.answer = new EmailOrPhone(str);
        this.addressFrom = addressFrom;
        this.addressTo = addressTo;
    }

    public User() {
    }

    public static User userWithNameAndSurname(int id, String code, String name, String surname, String addressFrom, String addressTo, String str) {
        return new User(id, code, name, surname, addressFrom, addressTo, str);
    }

    public static User userWithName(int id, String code, String name, String addressFrom, String addressTo, String str) {
        return new User(id, code, name, addressFrom, addressTo, str);
    }

    public static User userWithSurname(int id, String code, String surname, String addressFrom, String addressTo, String str) {
        User u = new User(id, code, addressFrom, addressTo, str);
        u.surname = surname;
        return u;
    }

    public static User userAnonim(int id, String code, String addressFrom, String addressTo, String str) {
        return new User(id, code, addressFrom, addressTo, str);
    }
}