package org.system.ticketsystem.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "TICKET", schema = "MAXIMO")
public class Ticket {
    @Id
    @Column(name = "TICKETUID", nullable = false)
    private Long id;

    @Size(max = 10)
    @NotNull
    @Column(name = "TICKETID", nullable = false, length = 10)
    private String ticketid;

    @Size(max = 16)
    @NotNull
    @Column(name = "CLASS", nullable = false, length = 16)
    private String classField;

    @Size(max = 320)
    @Column(name = "DESCRIPTION", length = 320)
    private String description;

    @Size(max = 10)
    @NotNull
    @Column(name = "STATUS", nullable = false, length = 10)
    private String status;

    @NotNull
    @Column(name = "STATUSDATE", nullable = false)
    private Instant statusdate;

    @Column(name = "REPORTEDPRIORITY")
    private Integer reportedpriority;

    @Column(name = "INTERNALPRIORITY")
    private Integer internalpriority;

    @Column(name = "IMPACT")
    private Integer impact;

    @Column(name = "URGENCY")
    private Integer urgency;

    @Size(max = 62)
    @Column(name = "REPORTEDBY", length = 62)
    private String reportedby;

    @Column(name = "REPORTDATE")
    private Instant reportdate;

    @Size(max = 62)
    @Column(name = "AFFECTEDPERSON", length = 62)
    private String affectedperson;

    @Column(name = "AFFECTEDDATE")
    private Instant affecteddate;

    @Size(max = 20)
    @Column(name = "SOURCE", length = 20)
    private String source;

    @Size(max = 40)
    @Column(name = "SUPERVISOR", length = 40)
    private String supervisor;

    @Size(max = 40)
    @Column(name = "OWNER", length = 40)
    private String owner;

    @Size(max = 40)
    @Column(name = "OWNERGROUP", length = 40)
    private String ownergroup;

    @NotNull
    @Column(name = "ISGLOBAL", nullable = false)
    private Integer isglobal;

    @NotNull
    @Column(name = "RELATEDTOGLOBAL", nullable = false)
    private Integer relatedtoglobal;

    @Size(max = 10)
    @Column(name = "GLOBALTICKETID", length = 10)
    private String globalticketid;

    @Size(max = 16)
    @Column(name = "GLOBALTICKETCLASS", length = 16)
    private String globalticketclass;

    @Size(max = 20)
    @Column(name = "EXTERNALRECID", length = 20)
    private String externalrecid;

    @NotNull
    @Column(name = "SITEVISIT", nullable = false)
    private Integer sitevisit;

    @Size(max = 10)
    @Column(name = "ORIGRECORDID", length = 10)
    private String origrecordid;

    @Size(max = 16)
    @Column(name = "ORIGRECORDCLASS", length = 16)
    private String origrecordclass;

    @Size(max = 110)
    @Column(name = "GLACCOUNT", length = 110)
    private String glaccount;

    @Size(max = 8)
    @Column(name = "COMMODITYGROUP", length = 8)
    private String commoditygroup;

    @Size(max = 8)
    @Column(name = "COMMODITY", length = 8)
    private String commodity;

    @NotNull
    @Column(name = "INHERITSTATUS", nullable = false)
    private Integer inheritstatus;

    @NotNull
    @Column(name = "ISKNOWNERROR", nullable = false)
    private Integer isknownerror;

    @Column(name = "TARGETSTART")
    private Instant targetstart;

    @Column(name = "TARGETFINISH")
    private Instant targetfinish;

    @Column(name = "ACTUALSTART")
    private Instant actualstart;

    @Column(name = "ACTUALFINISH")
    private Instant actualfinish;

    @Size(max = 8)
    @Column(name = "ORIGRECSITEID", length = 8)
    private String origrecsiteid;

    @Size(max = 8)
    @Column(name = "ORIGRECORGID", length = 8)
    private String origrecorgid;

    @Size(max = 8)
    @Column(name = "SITEID", length = 8)
    private String siteid;

    @Size(max = 8)
    @Column(name = "ORGID", length = 8)
    private String orgid;

    @NotNull
    @Column(name = "CHANGEDATE", nullable = false)
    private Instant changedate;

    @Size(max = 40)
    @NotNull
    @Column(name = "CHANGEBY", nullable = false, length = 40)
    private String changeby;

    @NotNull
    @Column(name = "HISTORYFLAG", nullable = false)
    private Integer historyflag;

    @NotNull
    @Column(name = "TEMPLATE", nullable = false)
    private Integer template;

    @NotNull
    @Column(name = "HASACTIVITY", nullable = false)
    private Integer hasactivity;

    @Size(max = 8)
    @Column(name = "FAILURECODE", length = 8)
    private String failurecode;

    @Size(max = 8)
    @Column(name = "PROBLEMCODE", length = 8)
    private String problemcode;

    @NotNull
    @Column(name = "ACTLABHRS", nullable = false)
    private Double actlabhrs;

    @NotNull
    @Column(name = "ACTLABCOST", nullable = false, precision = 10, scale = 2)
    private BigDecimal actlabcost;

    @Size(max = 20)
    @Column(name = "AFFECTEDPHONE", length = 20)
    private String affectedphone;

    @Size(max = 20)
    @Column(name = "REPORTEDPHONE", length = 20)
    private String reportedphone;

    @Size(max = 100)
    @Column(name = "AFFECTEDEMAIL", length = 100)
    private String affectedemail;

    @Size(max = 100)
    @Column(name = "REPORTEDEMAIL", length = 100)
    private String reportedemail;

    @Size(max = 8)
    @Column(name = "ASSETSITEID", length = 8)
    private String assetsiteid;

    @Size(max = 10)
    @Column(name = "TEMPLATEID", length = 10)
    private String templateid;

    @Size(max = 12)
    @Column(name = "VENDOR", length = 12)
    private String vendor;

    @Size(max = 12)
    @Column(name = "ASSETNUM", length = 12)
    private String assetnum;

    @Size(max = 15)
    @Column(name = "LOCATION", length = 15)
    private String location;

    @Size(max = 20)
    @Column(name = "CLASSSTRUCTUREID", length = 20)
    private String classstructureid;

    @Column(name = "ISKNOWNERRORDATE")
    private Instant isknownerrordate;

    @Column(name = "TARGETCONTACTDATE")
    private Instant targetcontactdate;

    @Column(name = "ACTUALCONTACTDATE")
    private Instant actualcontactdate;

    @Size(max = 8)
    @Column(name = "FR1CODE", length = 8)
    private String fr1code;

    @Size(max = 8)
    @Column(name = "FR2CODE", length = 8)
    private String fr2code;

    @Size(max = 8)
    @Column(name = "SOLUTION", length = 8)
    private String solution;

    @Size(max = 8)
    @Column(name = "ASSETORGID", length = 8)
    private String assetorgid;

    @Size(max = 4)
    @NotNull
    @Column(name = "LANGCODE", nullable = false, length = 4)
    private String langcode;

    @NotNull
    @Column(name = "HASLD", nullable = false)
    private Integer hasld;

    @Size(max = 150)
    @Column(name = "CINUM", length = 150)
    private String cinum;

    @Size(max = 8)
    @Column(name = "CREATEWOMULTI", length = 8)
    private String createwomulti;

    @Size(max = 50)
    @Column(name = "TARGETDESC", length = 50)
    private String targetdesc;

    @NotNull
    @Column(name = "SELFSERVSOLACCESS", nullable = false)
    private Integer selfservsolaccess;

    @NotNull
    @Column(name = "HASSOLUTION", nullable = false)
    private Integer hassolution;

    @Size(max = 8)
    @Column(name = "CALCORGID", length = 8)
    private String calcorgid;

    @Size(max = 8)
    @Column(name = "CALCCALENDAR", length = 8)
    private String calccalendar;

    @Size(max = 8)
    @Column(name = "CALCSHIFT", length = 8)
    private String calcshift;

    @Size(max = 40)
    @Column(name = "ASSIGNEDOWNERGROUP", length = 40)
    private String assignedownergroup;

    @Size(max = 12)
    @Column(name = "PLUSPAGREEMENT", length = 12)
    private String pluspagreement;

    @Size(max = 12)
    @Column(name = "PLUSPCUSTOMER", length = 12)
    private String pluspcustomer;

    @Size(max = 8)
    @Column(name = "PLUSPQUOTETYPE", length = 8)
    private String pluspquotetype;

    @Column(name = "PLUSPQUOTEDPRICE", precision = 10, scale = 2)
    private BigDecimal pluspquotedprice;

    @Size(max = 10)
    @Column(name = "PLUSPRESPONSEPLAN", length = 10)
    private String pluspresponseplan;

    @Column(name = "PLUSPREVNUM")
    private Integer plusprevnum;

    @Size(max = 10)
    @Column(name = "PLUSPPRICESCHED", length = 10)
    private String plusppricesched;

    @Size(max = 25)
    @Column(name = "PLUSPCUSTPONUM", length = 25)
    private String pluspcustponum;

    @Column(name = "PLUSPMAXPRICE", precision = 10, scale = 2)
    private BigDecimal pluspmaxprice;

    @Size(max = 12)
    @Column(name = "PLUSPBILLBATCH", length = 12)
    private String pluspbillbatch;

    @Column(name = "PLUSPBBLINENUM")
    private Integer pluspbblinenum;

    @Size(max = 16)
    @Column(name = "PLUSPCOSTCENTER", length = 16)
    private String pluspcostcenter;

    @Size(max = 20)
    @Column(name = "PLUSPCUSTCHACCT", length = 20)
    private String pluspcustchacct;

    @NotNull
    @Column(name = "PLUSPPOREQ", nullable = false)
    private Integer pluspporeq;

    @Size(max = 8)
    @Column(name = "PLUSPCALCORGID", length = 8)
    private String pluspcalcorgid;

    @Size(max = 8)
    @Column(name = "PLUSPCALCCALNUM", length = 8)
    private String pluspcalccalnum;

    @Size(max = 8)
    @Column(name = "PLUSPCALCSHIFT", length = 8)
    private String pluspcalcshift;

    @NotNull
    @Column(name = "ROWSTAMP", nullable = false)
    private Long rowstamp;

    @Size(max = 20)
    @Column(name = "PLUSPPOOLNUM", length = 20)
    private String plusppoolnum;

    @Size(max = 30)
    @Column(name = "PLUSPPOOLITEMNUM", length = 30)
    private String plusppoolitemnum;

    @Size(max = 8)
    @Column(name = "PLUSPPOOLITEMSETID", length = 8)
    private String plusppoolitemsetid;

    @Column(name = "PLUSPTARGDELIVERYDATE")
    private Instant plusptargdeliverydate;

    @Column(name = "PLUSPACTDELIVERYDATE")
    private Instant pluspactdeliverydate;

    @Size(max = 50)
    @Column(name = "PMCOMTYPE", length = 50)
    private String pmcomtype;

    @Size(max = 50)
    @Column(name = "PMCOMRESOLUTION", length = 50)
    private String pmcomresolution;

    @Column(name = "PMCOMIMPACT")
    private Integer pmcomimpact;

    @Column(name = "PMCOMURGENCY")
    private Integer pmcomurgency;

    @Size(max = 40)
    @Column(name = "ONCALLFIRSTROTASSNPERSON", length = 40)
    private String oncallfirstrotassnperson;

    @Column(name = "ONCALLSTARTTIME")
    private Instant oncallstarttime;

    @NotNull
    @Column(name = "ONCALLAUTOASSIGN", nullable = false)
    private Integer oncallautoassign;

    @Column(name = "ONCALLREASSIGNTIME")
    private Instant oncallreassigntime;

    @Size(max = 40)
    @Column(name = "ONCALLOWNERGROUP", length = 40)
    private String oncallownergroup;

    @Size(max = 40)
    @Column(name = "REPLACEDOWNER", length = 40)
    private String replacedowner;

    @Column(name = "INDICATEDPRIORITY")
    private Integer indicatedpriority;

    @Size(max = 1024)
    @Column(name = "EXTERNALSYSTEM_TICKETID", length = 1024)
    private String externalsystemTicketid;

    @Size(max = 512)
    @Column(name = "EXTERNALSYSTEM", length = 512)
    private String externalsystem;

    @Size(max = 51)
    @Column(name = "DESCSRVID", length = 51)
    private String descsrvid;

    @Size(max = 40)
    @Column(name = "CREATEDBY", length = 40)
    private String createdby;

    @Column(name = "CREATIONDATE")
    private Instant creationdate;

    @Column(name = "VIRTUALENV")
    private Integer virtualenv;

    @Column(name = "OUTAGEDURATION")
    private Double outageduration;

    @Size(max = 192)
    @Column(name = "CLASSIFICATIONID", length = 192)
    private String classificationid;

    @Size(max = 30)
    @Column(name = "PMSCCRID", length = 30)
    private String pmsccrid;

    @Size(max = 30)
    @Column(name = "PMSCITEMNUM", length = 30)
    private String pmscitemnum;

    @Size(max = 100)
    @Column(name = "PMSCOFFSUMMARY", length = 100)
    private String pmscoffsummary;

    @Column(name = "PMSCQUANTITY")
    private Integer pmscquantity;

    @Column(name = "PMCOSOLAPPLIEDDATE")
    private Instant pmcosolapplieddate;

    @Size(max = 40)
    @Column(name = "PMCOSOLAPPLIEDBY", length = 40)
    private String pmcosolappliedby;

    @Size(max = 250)
    @Column(name = "PMCOSOLFEEDBACK", length = 250)
    private String pmcosolfeedback;

    @Size(max = 12)
    @Column(name = "PMCOSOLSTATUS", length = 12)
    private String pmcosolstatus;

    @Size(max = 8)
    @Column(name = "PMSCITEMSETID", length = 8)
    private String pmscitemsetid;

    @Column(name = "PMSCTMPLID")
    private Long pmsctmplid;

    @Column(name = "PMSCINVALID")
    private Integer pmscinvalid;

    @Column(name = "PMSCRECURRINGPRICE", precision = 10, scale = 2)
    private BigDecimal pmscrecurringprice;

    @Column(name = "PMSCONETIMEPRICE", precision = 10, scale = 2)
    private BigDecimal pmsconetimeprice;

    @Column(name = "PMSCTOTALRECURRINGPRICE", precision = 10, scale = 2)
    private BigDecimal pmsctotalrecurringprice;

    @Column(name = "PMSCTOTALONETIMEPRICE", precision = 10, scale = 2)
    private BigDecimal pmsctotalonetimeprice;

    @Size(max = 8)
    @Column(name = "PMSCCURRENCY", length = 8)
    private String pmsccurrency;

    @Column(name = "ACCUMULATEDHOLDTIME")
    private Double accumulatedholdtime;

    @Column(name = "ADJUSTEDTARGETCONTACTTIME")
    private Instant adjustedtargetcontacttime;

    @Column(name = "ADJUSTEDTARGETRESPONSETIME")
    private Instant adjustedtargetresponsetime;

    @Column(name = "ADJUSTEDTARGETRESOLUTIONTIME")
    private Instant adjustedtargetresolutiontime;

    @Size(max = 1024)
    @Column(name = "CORRELATIONATTRS", length = 1024)
    private String correlationattrs;

    @Size(max = 15)
    @Column(name = "PLUSPREPAIRFACILITY", length = 15)
    private String plusprepairfacility;

    @Size(max = 8)
    @Column(name = "PLUSPREPFACSITEID", length = 8)
    private String plusprepfacsiteid;

    @Column(name = "PLUSPREPAIRDATE")
    private LocalDate plusprepairdate;

    @Size(max = 200)
    @Column(name = "RESDETAILS", length = 200)
    private String resdetails;

    @Size(max = 100)
    @Column(name = "REOPENREASON", length = 100)
    private String reopenreason;

    @Column(name = "REOPENCOUNT")
    private Integer reopencount;

    @Size(max = 100)
    @Column(name = "CANCELREASON", length = 100)
    private String cancelreason;

    @Size(max = 100)
    @Column(name = "REJECTREASON", length = 100)
    private String rejectreason;

    @Size(max = 40)
    @Column(name = "REJECTEDBY", length = 40)
    private String rejectedby;

    @Column(name = "REJECTEDDATE")
    private Instant rejecteddate;

    @Size(max = 100)
    @Column(name = "REASSIGNREASON", length = 100)
    private String reassignreason;

    @Column(name = "REASSIGNCOUNT")
    private Integer reassigncount;

    @Column(name = "RESDATE")
    private Instant resdate;

    @Size(max = 50)
    @Column(name = "REQUESTTYPE", length = 50)
    private String requesttype;

    @Size(max = 50)
    @Column(name = "YEARDATE", length = 50)
    private String yeardate;

    @Size(max = 40)
    @Column(name = "APPROVEDBY", length = 40)
    private String approvedby;

    @Column(name = "APPROVEDDATE")
    private Instant approveddate;

    @Size(max = 40)
    @Column(name = "PARENTDEPARTMENT", length = 40)
    private String parentdepartment;

    @Size(max = 40)
    @Column(name = "MAINDEPARTMENT", length = 40)
    private String maindepartment;

    @Size(max = 10000)
    @Column(name = "MAXIMOXCOPYPERSON", length = 10000)
    private String maximoxcopyperson;

    @Size(max = 10000)
    @Column(name = "MAXIMOXCOPYGROUP", length = 10000)
    private String maximoxcopygroup;

    @Size(max = 10)
    @Column(name = "APATKAUTONUMBER", length = 10)
    private String apatkautonumber;

    @Size(max = 40)
    @Column(name = "APPRL1", length = 40)
    private String apprl1;

    @Size(max = 40)
    @Column(name = "APPRL2", length = 40)
    private String apprl2;

    @Column(name = "APPRL1DATE")
    private Instant apprl1date;

    @Column(name = "APPRL2DATE")
    private Instant apprl2date;

    @Size(max = 200)
    @Column(name = "APPRREASON", length = 200)
    private String apprreason;

    @Size(max = 200)
    @Column(name = "APPRREASONL2", length = 200)
    private String apprreasonl2;

    @Column(name = "STARTDATE")
    private Instant startdate;

    @Column(name = "ENDDATE")
    private Instant enddate;

    @Size(max = 200)
    @Column(name = "DELAYREASON", length = 200)
    private String delayreason;

    @Size(max = 40)
    @Column(name = "REJECTBY", length = 40)
    private String rejectby;

    @Column(name = "REJECTDATE")
    private Instant rejectdate;

    @Size(max = 50)
    @Column(name = "CLIENTEMAIL", length = 50)
    private String clientemail;

    @Size(max = 50)
    @Column(name = "CLIENTNAME", length = 50)
    private String clientname;

    @Size(max = 50)
    @Column(name = "CLIENTNATIONALID", length = 50)
    private String clientnationalid;

    @Size(max = 50)
    @Column(name = "EFINANCEPAYCODE", length = 50)
    private String efinancepaycode;

    @Size(max = 50)
    @Column(name = "PAYMENTCONFIRMATION", length = 50)
    private String paymentconfirmation;

    @Size(max = 50)
    @Column(name = "PAYMENTFLAG", length = 50)
    private String paymentflag;

    @Size(max = 50)
    @Column(name = "PAYMENTID", length = 50)
    private String paymentid;

    @Size(max = 50)
    @Column(name = "PAYMENTIDHISTORY", length = 50)
    private String paymentidhistory;

    @Size(max = 50)
    @Column(name = "PAYMENTVALUE", length = 50)
    private String paymentvalue;

    @Size(max = 50)
    @Column(name = "REDIRECTIONURL", length = 50)
    private String redirectionurl;

    @Size(max = 50)
    @Column(name = "SERVICECODE", length = 50)
    private String servicecode;

    @Size(max = 20)
    @Column(name = "ENDPOINTNAME", length = 20)
    private String endpointname;

    @Column(name = "PAYMENTREQUESTNUMBER")
    private String paymentRequestNumber;

    @Column(name = "PAYMENTREQUESTTOTALAMOUNT")
    private String paymentRequestTotalAmount;

    @Column(name = "COLLECTIONFEESAMOUNT")
    private String collectionFeesAmount;

    @Column(name = "CUSTOMERAUTHORIZATIONAMOUNT")
    private String customerAuthorizationAmount;
    @Column(name = "AUTHORIZATIONCODE")
    private Double authorizationCode;
    @Column(name = "TRANSACTIONNUMBER")
    private String transactionNumber;
    @Column(name = "AUTHORIZINGINSTITUTION")
    private String authorizingInstitution;
    @Column(name = "AUTHORIZINGMECHANISM")
    private String authorizingMechanism;
    @Column(name = "AUTHORIZATIONDATETIME")
    private Date authorizationDateTime;
    @Column(name = "RECONCILIATIONDATE")
    private Date reconciliationDate;
    @Column(name = "ISCONFIRMED")
    private Boolean isConfirmed;
    @Column(name = "SENDERREQUESTNUMBER")
    private String senderRequestNumber;
}