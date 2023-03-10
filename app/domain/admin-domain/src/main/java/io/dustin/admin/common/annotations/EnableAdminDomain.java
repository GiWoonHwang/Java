package io.dustin.admin.common.annotations;

import io.dustin.admin.common.config.AdminDomainConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import({AdminDomainConfiguration.class})
public @interface EnableAdminDomain {
}
