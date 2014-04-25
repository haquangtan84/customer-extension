package org.exoplatform.portlet.customer;
import juzu.impl.request.Method;
import juzu.impl.request.Parameter;
import juzu.impl.request.PhaseParameter;
import juzu.impl.request.ContextualParameter;
import juzu.impl.common.Tools;
import java.util.Arrays;
import juzu.request.Phase;
import juzu.impl.plugin.controller.descriptor.ControllerDescriptor;
import javax.annotation.Generated;
import juzu.impl.common.Cardinality;
import juzu.impl.request.Request;
@Generated(value={})
public class CustomerApplication_ {
private static final Method<Phase.View> method_0 = new Method<Phase.View>("CustomerApplication.index",Phase.VIEW,org.exoplatform.portlet.customer.CustomerApplication.class,Tools.safeGetMethod(org.exoplatform.portlet.customer.CustomerApplication.class,"index",juzu.request.RenderContext.class), Arrays.<Parameter>asList(new ContextualParameter("renderContext",juzu.request.RenderContext.class)));
public static Phase.View.Dispatch index() { return Request.getCurrent().getContext().createViewDispatch(method_0); }
public static final ControllerDescriptor DESCRIPTOR = new ControllerDescriptor(CustomerApplication.class,Arrays.<Method<?>>asList(method_0));
}
