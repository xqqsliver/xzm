package com.xz.service.frame.spring;

import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConstructorArgumentValues;
import org.springframework.beans.factory.support.AutowireCandidateQualifier;
import org.springframework.beans.factory.support.MethodOverrides;
import org.springframework.core.io.Resource;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 解析之后的model,好比AbstractBeanDefinition
 */
public class ParseBeanModel {
    public static final String SCOPE_DEFAULT = "";


    public static final int AUTOWIRE_NO = AutowireCapableBeanFactory.AUTOWIRE_NO;


    public static final int AUTOWIRE_BY_NAME = AutowireCapableBeanFactory.AUTOWIRE_BY_NAME;


    public static final int AUTOWIRE_BY_TYPE = AutowireCapableBeanFactory.AUTOWIRE_BY_TYPE;


    public static final int AUTOWIRE_CONSTRUCTOR = AutowireCapableBeanFactory.AUTOWIRE_CONSTRUCTOR;

    public static final int DEPENDENCY_CHECK_NONE = 0;


    public static final int DEPENDENCY_CHECK_OBJECTS = 1;


    public static final int DEPENDENCY_CHECK_SIMPLE = 2;


    public static final int DEPENDENCY_CHECK_ALL = 3;


    public static final String INFER_METHOD = "(inferred)";


    private volatile Object beanClass;
    private  String parent;

    private String scope = SCOPE_DEFAULT;

    private boolean abstractFlag = false;

    private boolean lazyInit = false;

    private int autowireMode = AUTOWIRE_NO;

    private int dependencyCheck = DEPENDENCY_CHECK_NONE;

    private String[] dependsOn;

    private boolean autowireCandidate = true;

    private boolean primary = false;

    private final Map<String, AutowireCandidateQualifier> qualifiers =
            new LinkedHashMap<String, AutowireCandidateQualifier>(0);

    private boolean nonPublicAccessAllowed = true;

    private boolean lenientConstructorResolution = true;

    private String factoryBeanName;

    private String factoryMethodName;

    private ConstructorArgumentValues constructorArgumentValues;

    private MutablePropertyValues propertyValues;

    private MethodOverrides methodOverrides = new MethodOverrides();

    private String initMethodName;

    private String destroyMethodName;

    private boolean enforceInitMethod = true;

    private boolean enforceDestroyMethod = true;

    private boolean synthetic = false;

    private int role = BeanDefinition.ROLE_APPLICATION;

    private String description;

    private Resource resource;
    private String className;

    public Object getBeanClass() {
        return beanClass;
    }

    public String getScope() {
        return scope;
    }

    public boolean isAbstractFlag() {
        return abstractFlag;
    }

    public boolean isLazyInit() {
        return lazyInit;
    }

    public int getAutowireMode() {
        return autowireMode;
    }

    public int getDependencyCheck() {
        return dependencyCheck;
    }

    public String[] getDependsOn() {
        return dependsOn;
    }

    public boolean isAutowireCandidate() {
        return autowireCandidate;
    }

    public boolean isPrimary() {
        return primary;
    }

    public Map<String, AutowireCandidateQualifier> getQualifiers() {
        return qualifiers;
    }

    public boolean isNonPublicAccessAllowed() {
        return nonPublicAccessAllowed;
    }

    public boolean isLenientConstructorResolution() {
        return lenientConstructorResolution;
    }

    public String getFactoryBeanName() {
        return factoryBeanName;
    }

    public String getFactoryMethodName() {
        return factoryMethodName;
    }

    public ConstructorArgumentValues getConstructorArgumentValues() {
        return constructorArgumentValues;
    }

    public MutablePropertyValues getPropertyValues() {
        return propertyValues;
    }

    public MethodOverrides getMethodOverrides() {
        return methodOverrides;
    }

    public String getInitMethodName() {
        return initMethodName;
    }

    public String getDestroyMethodName() {
        return destroyMethodName;
    }

    public boolean isEnforceInitMethod() {
        return enforceInitMethod;
    }

    public boolean isEnforceDestroyMethod() {
        return enforceDestroyMethod;
    }

    public boolean isSynthetic() {
        return synthetic;
    }

    public int getRole() {
        return role;
    }

    public String getDescription() {
        return description;
    }

    public Resource getResource() {
        return resource;
    }

    public String getParent() {
        return parent;
    }

    public void setBeanClass(Object beanClass) {
        this.beanClass = beanClass;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public void setAbstractFlag(boolean abstractFlag) {
        this.abstractFlag = abstractFlag;
    }

    public void setLazyInit(boolean lazyInit) {
        this.lazyInit = lazyInit;
    }

    public void setAutowireMode(int autowireMode) {
        this.autowireMode = autowireMode;
    }

    public void setDependencyCheck(int dependencyCheck) {
        this.dependencyCheck = dependencyCheck;
    }

    public void setDependsOn(String[] dependsOn) {
        this.dependsOn = dependsOn;
    }

    public void setAutowireCandidate(boolean autowireCandidate) {
        this.autowireCandidate = autowireCandidate;
    }

    public void setPrimary(boolean primary) {
        this.primary = primary;
    }

    public void setNonPublicAccessAllowed(boolean nonPublicAccessAllowed) {
        this.nonPublicAccessAllowed = nonPublicAccessAllowed;
    }

    public void setLenientConstructorResolution(boolean lenientConstructorResolution) {
        this.lenientConstructorResolution = lenientConstructorResolution;
    }

    public void setFactoryBeanName(String factoryBeanName) {
        this.factoryBeanName = factoryBeanName;
    }

    public void setFactoryMethodName(String factoryMethodName) {
        this.factoryMethodName = factoryMethodName;
    }

    public void setConstructorArgumentValues(ConstructorArgumentValues constructorArgumentValues) {
        this.constructorArgumentValues = constructorArgumentValues;
    }

    public void setPropertyValues(MutablePropertyValues propertyValues) {
        this.propertyValues = propertyValues;
    }

    public void setMethodOverrides(MethodOverrides methodOverrides) {
        this.methodOverrides = methodOverrides;
    }

    public void setInitMethodName(String initMethodName) {
        this.initMethodName = initMethodName;
    }

    public void setDestroyMethodName(String destroyMethodName) {
        this.destroyMethodName = destroyMethodName;
    }

    public void setEnforceInitMethod(boolean enforceInitMethod) {
        this.enforceInitMethod = enforceInitMethod;
    }

    public void setEnforceDestroyMethod(boolean enforceDestroyMethod) {
        this.enforceDestroyMethod = enforceDestroyMethod;
    }

    public void setSynthetic(boolean synthetic) {
        this.synthetic = synthetic;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
    public void setAbstract(boolean abstractFlag) {
        this.abstractFlag = abstractFlag;
    }

    public boolean isAbstract() {
        return this.abstractFlag;
    }

}
