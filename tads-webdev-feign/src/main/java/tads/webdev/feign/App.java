
package tads.webdev.feign;

import java.util.List;

import feign.Feign;
import feign.gson.GsonDecoder;
import feign.jaxrs.JAXRSContract;

public class App {

    public static void main(String[] args) {

        IGitHubRepository github = Feign.builder()
            .contract(new JAXRSContract())
            .decoder(new GsonDecoder())
            .target(IGitHubRepository.class, "https://api.github.com");

        List<Contributor> contribuidores = github.contribuidores(
            "OpenFeign", "feign");

        for (Contributor contribuidor : contribuidores) {

            System.out.println(contribuidor);

        }

    }

}
