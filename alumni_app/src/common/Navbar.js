import React from "react";
import { makeStyles } from '@material-ui/core/styles';
import Header from "../pages/dashboard/Header";
import { AppBar, IconButton, Toolbar, Typography } from "@material-ui/core";
import { useKeycloak } from "@react-keycloak/web";
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

                    {
                        initialized ? <div className="hidden xl:flex items-center space-x-5">
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
                      : <p>yes</p>
                    }
                    
                </Toolbar>
            </AppBar>
        </div>
    );
}