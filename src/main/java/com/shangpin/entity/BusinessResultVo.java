package com.shangpin.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.List;


@Data
@EqualsAndHashCode
@Accessors(chain = true)
public class BusinessResultVo {
    private ResultBeanX result;
    private String reason;
    private int error_code;

    @Data
    @EqualsAndHashCode
    @Accessors(chain = true)
    public static class ResultBeanX {
        private String historyNames;
        private String regStatus;
        private String bondNum;
        private int type;
        private String bondName;
        private Object revokeReason;
        private String property3;
        private String usedBondName;
        private long approvedTime;
        private long id;
        private String orgNumber;
        private String businessScope;
        private String taxNumber;
        private Object regCapitalCurrency;
        private String tags;
        private String phoneNumber;
        private String name;
        private int percentileScore;
        private int isMicroEnt;
        private Object cancelDate;
        private String regCapital;
        private String staffNumRange;
        private String industry;
        private StaffListBean staffList;
        private Object revokeDate;
        private String legalPersonName;
        private String regNumber;
        private String creditCode;
        private long fromTime;
        private int socialStaffNum;
        private String alias;
        private String companyOrgType;
        private Object actualCapitalCurrency;
        private Object cancelReason;
        private String email;
        private long toTime;
        private String actualCapital;
        private long estiblishTime;
        private String regInstitute;
        private String regLocation;
        private String websiteList;
        private String bondType;
        private String base;
        private List<String> historyNameList;

        @Data
        @EqualsAndHashCode
        @Accessors(chain = true)
        public static class StaffListBean {
            private int total;
            private List<ResultBean> result;

            @Data
            @EqualsAndHashCode
            @Accessors(chain = true)
            public static class ResultBean {

                private String name;
                private long id;
                private int type;
                private List<String> typeJoin;
            }
        }
    }
}
