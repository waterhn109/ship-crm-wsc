
package com.oa;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>anonymous complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="in0" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="in1" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="in2" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="in3" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="in4" type="{http://webservices.workflow.weaver}ArrayOfString"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "in0",
    "in1",
    "in2",
    "in3",
    "in4"
})
@XmlRootElement(name = "getAllWorkflowRequestList")
public class GetAllWorkflowRequestList {

    protected int in0;
    protected int in1;
    protected int in2;
    protected int in3;
    @XmlElement(required = true, nillable = true)
    protected ArrayOfString in4;

    /**
     * ��ȡin0���Ե�ֵ��
     * 
     */
    public int getIn0() {
        return in0;
    }

    /**
     * ����in0���Ե�ֵ��
     * 
     */
    public void setIn0(int value) {
        this.in0 = value;
    }

    /**
     * ��ȡin1���Ե�ֵ��
     * 
     */
    public int getIn1() {
        return in1;
    }

    /**
     * ����in1���Ե�ֵ��
     * 
     */
    public void setIn1(int value) {
        this.in1 = value;
    }

    /**
     * ��ȡin2���Ե�ֵ��
     * 
     */
    public int getIn2() {
        return in2;
    }

    /**
     * ����in2���Ե�ֵ��
     * 
     */
    public void setIn2(int value) {
        this.in2 = value;
    }

    /**
     * ��ȡin3���Ե�ֵ��
     * 
     */
    public int getIn3() {
        return in3;
    }

    /**
     * ����in3���Ե�ֵ��
     * 
     */
    public void setIn3(int value) {
        this.in3 = value;
    }

    /**
     * ��ȡin4���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfString }
     *     
     */
    public ArrayOfString getIn4() {
        return in4;
    }

    /**
     * ����in4���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfString }
     *     
     */
    public void setIn4(ArrayOfString value) {
        this.in4 = value;
    }

}
