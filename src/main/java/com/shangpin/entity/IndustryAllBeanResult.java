package com.shangpin.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@EqualsAndHashCode
@Accessors(chain = true)
public class IndustryAllBeanResult {

    /**
     * result : {"historyNames":"厦门研悟教育咨询有限公司\t","regStatus":"存续","type":1,"approvedTime":1576166400000,"id":2349739792,"orgNumber":"065880862","businessScope":"图书","taxNumber":"91350203065880862R","regCapitalCurrency":"人民币","district":"集美区","name":"厦门青蜂互动教育科技有限公司","percentileScore":5839,"industryAll":{"categoryMiddle":"  软件开发","categoryBig":"软件和信息技术服务业","category":"信息传输、软件和信息技术服务业","categorySmall":""},"isMicroEnt":1,"regCapital":"100万人民币","city":"厦门市","staffNumRange":"小于50人","historyNameList":["厦门研悟教育咨询有限公司"],"industry":"软件和信息技术服务业","updateTimes":1606337602000,"legalPersonName":"张亢亢","regNumber":"350211200068802","creditCode":"91350203065880862R","fromTime":1369152000000,"socialStaffNum":4,"actualCapitalCurrency":"人民币","alias":"青蜂互动","companyOrgType":"有限责任公司(自然人投资或控股)","toTime":2946902400000,"actualCapital":"10万人民币","estiblishTime":1369152000000,"regInstitute":"厦门市集美区市场监督管理局","regLocation":"厦门市集美区集美大道1302号创业大厦第七层705单元之二","base":"fj"}
     * reason : ok
     * error_code : 0
     */

    private ResultBean result;
    private String reason;
    private int error_code;

    @Data
    @EqualsAndHashCode
    @Accessors(chain = true)
    public static class ResultBean {
        private String historyNames;
        private String regStatus;
        private int type;
        private long approvedTime;
        private long id;
        private String orgNumber;
        private String businessScope;
        private String taxNumber;
        private String regCapitalCurrency;
        private String district;
        private String name;
        private int percentileScore;
        private IndustryAllBean industryAll;
        private int isMicroEnt;
        private String regCapital;
        private String city;
        private String staffNumRange;
        private String industry;
        private long updateTimes;
        private String legalPersonName;
        private String regNumber;
        private String creditCode;
        private long fromTime;
        private int socialStaffNum;
        private String actualCapitalCurrency;
        private String alias;
        private String companyOrgType;
        private long toTime;
        private String actualCapital;
        private long estiblishTime;
        private String regInstitute;
        private String regLocation;
        private String base;
        private List<String> historyNameList;

        @Data
        @EqualsAndHashCode
        @Accessors(chain = true)
        public static class IndustryAllBean {
            private String categoryMiddle;
            private String categoryBig;
            private String category;
            private String categorySmall;
        }
    }
}
