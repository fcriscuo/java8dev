/**
 * This class is generated by jOOQ
 */
package org.nygenome.cdrn.nyc.sitestudy.h2.generated.tables.pojos;


import java.io.Serializable;

import javax.annotation.Generated;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.8.1"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class CohortStudySite implements Serializable {

    private static final long serialVersionUID = -1139376880;

    private Long   cohortStudySiteId;
    private Long   cohortStudyId;
    private String siteCode;

    public CohortStudySite() {}

    public CohortStudySite(CohortStudySite value) {
        this.cohortStudySiteId = value.cohortStudySiteId;
        this.cohortStudyId = value.cohortStudyId;
        this.siteCode = value.siteCode;
    }

    public CohortStudySite(
        Long   cohortStudySiteId,
        Long   cohortStudyId,
        String siteCode
    ) {
        this.cohortStudySiteId = cohortStudySiteId;
        this.cohortStudyId = cohortStudyId;
        this.siteCode = siteCode;
    }

    public Long getCohortStudySiteId() {
        return this.cohortStudySiteId;
    }

    public void setCohortStudySiteId(Long cohortStudySiteId) {
        this.cohortStudySiteId = cohortStudySiteId;
    }

    public Long getCohortStudyId() {
        return this.cohortStudyId;
    }

    public void setCohortStudyId(Long cohortStudyId) {
        this.cohortStudyId = cohortStudyId;
    }

    public String getSiteCode() {
        return this.siteCode;
    }

    public void setSiteCode(String siteCode) {
        this.siteCode = siteCode;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("CohortStudySite (");

        sb.append(cohortStudySiteId);
        sb.append(", ").append(cohortStudyId);
        sb.append(", ").append(siteCode);

        sb.append(")");
        return sb.toString();
    }
}
