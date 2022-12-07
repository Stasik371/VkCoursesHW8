package commons.guice;

import api.DataREST;
import api.InfoREST;
import com.google.inject.AbstractModule;
import com.google.inject.Module;
import server.handlers.JacksonMessageBodyHandler;
import commons.server.ObjectMapperProvider;
import org.jboss.resteasy.plugins.guice.GuiceResteasyBootstrapServletContextListener;

import javax.servlet.ServletContext;
import java.util.Collections;

import java.util.List;

public final class GuiceListener extends GuiceResteasyBootstrapServletContextListener{
    @Override
    protected List<? extends Module> getModules(ServletContext context) {
        return Collections.singletonList(new GuiceModule());
    }

    @SuppressWarnings("rawtypes")
    private static final class GuiceModule extends AbstractModule {
        @Override
        protected void configure() {
            bind(JacksonMessageBodyHandler.class).toInstance(new JacksonMessageBodyHandler());
            bind(ObjectMapperProvider.class).toInstance(new ObjectMapperProvider());
            bind(DataREST.class);
            bind(InfoREST.class).toInstance(new InfoREST());
        }
    }
}
