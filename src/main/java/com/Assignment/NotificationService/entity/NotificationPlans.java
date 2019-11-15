package com.Assignment.NotificationService.entity;

public enum NotificationPlans {

    Gold(10000000L,true,true,false),
    Platinum(0L,true,true,true),
    Silver(1000000L,true,false,false);

    private Long Limit;
    private Boolean isEmailIncluded;
    private Boolean isSmsIncluded;
    private Boolean isPushIncluded;

    NotificationPlans(Long limit, Boolean isEmailIncluded, Boolean isSmsIncluded, Boolean isPushIncluded) {
        Limit = limit;
        this.isEmailIncluded = isEmailIncluded;
        this.isSmsIncluded = isSmsIncluded;
        this.isPushIncluded = isPushIncluded;
    }

    public Long getLimit() {
        return this.Limit;
    }

    public Boolean isEmailIncluded() {
        return this.isEmailIncluded;
    }

    public Boolean isSmsIncluded() {
        return this.isSmsIncluded;
    }

    public Boolean isPushIncluded() {
        return this.isPushIncluded;
    }





}