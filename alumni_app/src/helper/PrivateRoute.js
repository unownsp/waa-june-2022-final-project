import { useKeycloak } from "@react-keycloak/web";
import LoginRequired from "./LoginRequired";

const PrivateRoute = ({ children }) => {
 const { keycloak } = useKeycloak();

 const isLoggedIn = keycloak.authenticated;
 console.log(isLoggedIn);
 return isLoggedIn ? children : LoginRequired;
};

export default PrivateRoute;