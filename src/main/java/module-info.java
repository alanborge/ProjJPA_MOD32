/**
 * 
 */
/**
 * 
 */
module ProjJPA_MOD32 {
	
	requires java.desktop;
	requires java.xml;
	requires jdk.compiler;
	requires jdk.javadoc;
	requires junit;
	requires java.persistence;
	exports br.borges.com.domain;
	opens br.borges.com.domain to org.hibernate.orm.core;
}