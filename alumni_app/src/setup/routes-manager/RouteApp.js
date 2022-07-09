import React from "react";
import { Route, Routes } from "react-router";
import HomePage from "../../pages/dashboard/HomePage";
import FacultyList from "../../pages/faculty/FacultyList";
import StudentList from "../../pages/student/StudentList";
import Jobs from "../../pages/job/Jobs";
import PrivateRoute from "../../helper/PrivateRoute";


export default function RouteApp() {
    return (
        <>
            <Routes>
                <Route path='/' element={<HomePage />}></Route>
                <Route path='/Students' element={
                    <PrivateRoute>
                        <StudentList />
                    </PrivateRoute>
                }></Route>
                <Route path='/Faculties' element={<FacultyList />}></Route>
                <Route path='/Jobs' element={<Jobs />}></Route>
            </Routes>
        </>
    )
}

//element={<PrivateRoute><StudentList /></PrivateRoute>}>
//