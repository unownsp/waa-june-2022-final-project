import React from "react";
import { makeStyles } from '@material-ui/core/styles';
import Header from "../pages/dashboard/Header";
import { AppBar, IconButton, Toolbar, Typography } from "@material-ui/core";
import { useKeycloak } from "@react-keycloak/web";
//import { useNavigate, NavLink } from "react-router";
import { useNavigate } from "react-router";

const useStyles = makeStyles((theme) => ({
    root: {
        flexGrow: 1,
    },
    menuButton: {
    },
}));

export default function Navbar() {
    const classes = useStyles();
    const { keycloak, initialized } = useKeycloak();
    const navigate = useNavigate();

    const handleLogInOut = () => {
      if (keycloak.authenticated) {
        // props.history.push('/')
        keycloak.logout()
      } else {
        keycloak.login()
      }
    }
  
    const checkAuthenticated = () => {
      if (!keycloak.authenticated) {
        handleLogInOut()
      }
    }
  
    const getUsername = () => {
      return keycloak.authenticated && keycloak.tokenParsed && keycloak.tokenParsed.preferred_username
    }
  
    const getLogInOutText = () => {
      return keycloak.authenticated ? "Logout" : "Login"
    }

    return (
        <div className={classes.root}>
            <AppBar position="static">
                <Toolbar variant="dense">
                    <Typography variant="h6" color="inherit">
                        <span onClick={() => { navigate('/') }} className="pointer">  Alumini Management Portal</span>
                    </Typography>
                    <IconButton edge="start"
                        className={classes.root}
                        color="inherit" aria-label="menu">
                        <Header></Header>
                    </IconButton>

                     <div className="hidden xl:flex items-center space-x-5">
                        <div className="hover:text-gray-200">
                          {!keycloak.authenticated && (
                            <button
                              type="button"
                              className="text-blue-800"
                              onClick={() => keycloak.login()}
                            >
                              Login
                            </button>
                          )}
         
                          {!!keycloak.authenticated && (
                            <button
                              type="button"
                              className="text-blue-800"
                              onClick={() => keycloak.logout()}
                            >
                              Logout ({keycloak.tokenParsed.preferred_username})
                            </button>
                          )}
                        </div>
                      </div>
                      
                  
                    
                    {/* <Menu.Item as={NavLink} exact to="/login" onClick={handleLogInOut}>{getLogInOutText()}</Menu.Item> */}
                    
                </Toolbar>
            </AppBar>
        </div>
    );
}