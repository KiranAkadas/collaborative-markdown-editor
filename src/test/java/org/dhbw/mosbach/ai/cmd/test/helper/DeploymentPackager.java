package org.dhbw.mosbach.ai.cmd.test.helper;

import org.dhbw.mosbach.ai.cmd.test.include.DependencyIncludes;
import org.dhbw.mosbach.ai.cmd.test.include.PackageIncludes;
import org.jboss.shrinkwrap.api.Filters;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.resolver.api.maven.Maven;

import static org.dhbw.mosbach.ai.cmd.test.config.DeploymentConfig.*;

/**
 * @author 6694964
 * @version 1.1
 */
public final class DeploymentPackager {

    private DeploymentPackager() {
        /* don't let anyone instantiate this class from outside */
    }

    public static Builder createDeployment(String deploymentName) {
        return new Builder(deploymentName);
    }

    public static final class Builder {

        private final WebArchive archive;

        private Builder(String deploymentName) {
            this.archive = ShrinkWrap.create(WebArchive.class, deploymentName + ".war");
        }

        public Builder addMavenRuntimeAndTestDependencies() {
            archive.addAsLibraries(Maven.resolver().loadPomFromFile(PROJECT_POM)
                                        .importRuntimeAndTestDependencies()
                                        .resolve()
                                        .withTransitivity()
                                        .asFile());
            return this;
        }

        public Builder addMavenDependencies(DependencyIncludes includes) {
            archive.addAsLibraries(Maven.resolver().resolve(includes.getDependencies()).withoutTransitivity().asFile());
            return this;
        }

        public Builder addBeansAndPersistenceDefinition() {
            archive.addAsResource(BEANS_XML)
                   .addAsResource(TEST_PERSISTENCE_XML, PERSISTENCE_XML);
            return this;
        }

        public Builder addTestResources() {
            archive.addAsResource(LOG4J_PROPERTIES);
            return this;
        }

        public Builder addPackages(PackageIncludes includes) {
            archive.addPackages(true, Filters.exclude(".*Test$"), includes.getPackages());
            return this;
        }

        public Builder addClasses(Class<?>... classes) {
            archive.addClasses(classes);
            return this;
        }

        public WebArchive packageWebArchive() {
            return archive;
        }
    }
}
