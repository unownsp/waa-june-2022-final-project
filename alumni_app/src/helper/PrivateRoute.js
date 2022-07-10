import React from 'react'
import { useKeycloak } from "@react-keycloak/web";
import { Route } from 'react-router-dom';


const PrivateRoute = ({ children }) => {
 const { keycloak } = useKeycloak();

 const isLoggedIn = keycloak.authenticated;
 debugger
 console.log("data in private route" + isLoggedIn +"  "+ keycloak);
 return isLoggedIn ? children : keycloak.login();

// const { keycloak } = useKeycloak()
//   return (
//     <Route
//       {...rest}
//       render={props => (
//         keycloak?.authenticated ? children : keycloak.login()
//       )}
//     />
//   )
};

export default PrivateRoute;