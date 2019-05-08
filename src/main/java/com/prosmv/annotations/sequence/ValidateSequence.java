package com.prosmv.annotations.sequence;

import javax.validation.GroupSequence;
import javax.validation.groups.Default;

import com.prosmv.annotations.groups.BrandGroup;
import com.prosmv.annotations.groups.CompanyGroup;
import com.prosmv.annotations.groups.CustomerGroup;
import com.prosmv.annotations.groups.DesignationGroup;
import com.prosmv.annotations.groups.EmailGroup;
import com.prosmv.annotations.groups.FactoryGroup;
import com.prosmv.annotations.groups.MinMaxGroup;
import com.prosmv.annotations.groups.MobileGroup;
import com.prosmv.annotations.groups.NotNullGroup;
import com.prosmv.annotations.groups.PasswordGroup;
import com.prosmv.annotations.groups.UserGroup;

@GroupSequence(value = { NotNullGroup.class, EmailGroup.class, MobileGroup.class, MinMaxGroup.class, CompanyGroup.class,
		FactoryGroup.class, CustomerGroup.class, BrandGroup.class, DesignationGroup.class, UserGroup.class })
public interface ValidateSequence {

}
