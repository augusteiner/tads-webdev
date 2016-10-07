
package tads.webdev.feign;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

public interface IGitHubRepository {

    @GET @Path("/repos/{owner}/{repo}/contributors")
    List<Contributor> contribuidores(@PathParam("owner") String owner, @PathParam("repo") String repo);

}
