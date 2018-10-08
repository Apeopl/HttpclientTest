/**
 * YyksAndYsQueryRequest.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.hospital.Service;

public class YyksAndYsQueryRequest  implements java.io.Serializable {
    private java.lang.String jsrq;

    private java.lang.String ksrq;

    private java.lang.String yydm;

    public YyksAndYsQueryRequest() {
    }

    public YyksAndYsQueryRequest(
           java.lang.String jsrq,
           java.lang.String ksrq,
           java.lang.String yydm) {
           this.jsrq = jsrq;
           this.ksrq = ksrq;
           this.yydm = yydm;
    }


    /**
     * Gets the jsrq value for this YyksAndYsQueryRequest.
     * 
     * @return jsrq
     */
    public java.lang.String getJsrq() {
        return jsrq;
    }


    /**
     * Sets the jsrq value for this YyksAndYsQueryRequest.
     * 
     * @param jsrq
     */
    public void setJsrq(java.lang.String jsrq) {
        this.jsrq = jsrq;
    }


    /**
     * Gets the ksrq value for this YyksAndYsQueryRequest.
     * 
     * @return ksrq
     */
    public java.lang.String getKsrq() {
        return ksrq;
    }


    /**
     * Sets the ksrq value for this YyksAndYsQueryRequest.
     * 
     * @param ksrq
     */
    public void setKsrq(java.lang.String ksrq) {
        this.ksrq = ksrq;
    }


    /**
     * Gets the yydm value for this YyksAndYsQueryRequest.
     * 
     * @return yydm
     */
    public java.lang.String getYydm() {
        return yydm;
    }


    /**
     * Sets the yydm value for this YyksAndYsQueryRequest.
     * 
     * @param yydm
     */
    public void setYydm(java.lang.String yydm) {
        this.yydm = yydm;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof YyksAndYsQueryRequest)) return false;
        YyksAndYsQueryRequest other = (YyksAndYsQueryRequest) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.jsrq==null && other.getJsrq()==null) || 
             (this.jsrq!=null &&
              this.jsrq.equals(other.getJsrq()))) &&
            ((this.ksrq==null && other.getKsrq()==null) || 
             (this.ksrq!=null &&
              this.ksrq.equals(other.getKsrq()))) &&
            ((this.yydm==null && other.getYydm()==null) || 
             (this.yydm!=null &&
              this.yydm.equals(other.getYydm())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getJsrq() != null) {
            _hashCode += getJsrq().hashCode();
        }
        if (getKsrq() != null) {
            _hashCode += getKsrq().hashCode();
        }
        if (getYydm() != null) {
            _hashCode += getYydm().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

}
