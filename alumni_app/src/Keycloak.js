import Keycloak from "keycloak-js";


const keycloak = new Keycloak({
 url: "http://localhost:8080",
 realm: "SpringBootKeycloak",
 clientId: "alumniapp",
//  "ssl-required": "none",
//  "public-client": true,
// "confidential-port": 0
});

export default keycloak;

// {
//     "realm": "SpringBootKeycloak",
//     "auth-server-url": "http://localhost:8080/",
//     "ssl-required": "external",
//     "resource": "alumniapp",
//     "public-client": true,
//     "confidential-port": 0
//   }