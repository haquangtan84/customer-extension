package org.exoplatform.portlet.customer.templates;
import juzu.impl.plugin.template.metadata.TemplateDescriptor;
import juzu.impl.plugin.template.TemplatePlugin;
@javax.annotation.Generated({})
@juzu.Path("index.gtmpl")
public class index extends juzu.template.Template
{
@javax.inject.Inject
public index(TemplatePlugin templatePlugin)
{
super(templatePlugin, "index.gtmpl", juzu.impl.template.spi.juzu.dialect.gtmpl.GroovyTemplateStub.class);
}
public static final juzu.impl.plugin.template.metadata.TemplateDescriptor DESCRIPTOR = new juzu.impl.plugin.template.metadata.TemplateDescriptor(org.exoplatform.portlet.customer.templates.index.class,juzu.impl.template.spi.juzu.dialect.gtmpl.GroovyTemplateStub.class);
public Builder builder() {
return new Builder();
}
public Builder with() {
return (Builder)super.with();
}
public class Builder extends juzu.template.Template.Builder
{
}
}
