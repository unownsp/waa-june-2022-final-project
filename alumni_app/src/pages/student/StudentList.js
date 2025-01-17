import { Box, Button } from "@mui/material";
import React, { useEffect, useRef, useState } from "react";
import AutoCompleteSelect from "../../common/AutoCompleteSelect";
import TableMain from "../../common/TableMain";


const listParams = {
    'showDetail': true,
    'showEdit': true,
    'showDelete': true,
    'showAddComment': true,
    'dataUrl': "/students/''/''/''/''/''",
    'addCommentUrl': '/Comments/',
    'editUrl': '',
    'deleteUrl': '/students/',
    'detailUrl': '/StudentDetails/'
}

export default function StudentList() {
    const [state, setState] = useState();
    const [city, setCity] = useState();
    const [major, setMajor] = useState();
    const [name, setName] = useState();
    const [id, setId] = useState();
    const [listParamsD, setlistParamsD] = useState(listParams);

    const setValue = (name, value) => {
        let title = 'undefined';
        if (value[0] != null) {
            title = value[0].title;
        }
        switch (name) {
            case 'state':
                setState(title);
                break;
            case 'city':
                setCity(title);
                break;
            case 'major':
                setMajor(title);
                break;
            case 'name':
                setName(title);
                break;
            case 'studentId':
                setId(title);
                break;
        }
    }

    const reLoadList = () => {
        const url = '/students/' + state + "/" + city + "/" + major + "/" + name + "/" + id;
        setlistParamsD({ ...listParamsD, 'dataUrl': url })
    }

    return (
        <>
            <span className="badge rounded-pill bg-primary mb-2"> Student List</span>
            <div className="float-end mt-4">
                <Button variant="contained" color="success" onClick={reLoadList}>Search</Button>
            </div>
            <div className="row body-custom">
                <Box sx={{ display: 'grid', gridTemplateColumns: 'repeat(5, 1fr)' }}>
                    <div>
                        < AutoCompleteSelect
                            name="state"
                            onChange={value => setValue('state', value)}
                            isMultiSelect={false}
                            label={"State"}
                            placeholder={"Eg. iowa, california"}
                            dataUrl='/reports/state' ></AutoCompleteSelect >
                    </div>
                    <div>
                        < AutoCompleteSelect
                            name="city"
                            onChange={value => setValue('city', value)}
                            isMultiSelect={false}
                            label={"City"}
                            placeholder={"Eg. fairfield, ottumwa"}
                            dataUrl='/reports/city' ></AutoCompleteSelect >
                    </div>
                    <div>
                        < AutoCompleteSelect
                            name="major"
                            onChange={value => setValue('major', value)}
                            isMultiSelect={false}
                            label={"Major"}
                            placeholder={"Eg. mpp, fpp"}
                            dataUrl='/reports/major' ></AutoCompleteSelect >
                    </div>
                    <div>
                        < AutoCompleteSelect
                            name="name"
                            onChange={value => setValue('name', value)}
                            isMultiSelect={false}
                            label={"Student Name"}
                            placeholder={"Eg. messi, ronaldo, pele"}
                            dataUrl='/reports/studentName' ></AutoCompleteSelect >
                    </div>
                    <div>
                        < AutoCompleteSelect
                            name="studentId"
                            onChange={value => setValue('studentId', value)}
                            isMultiSelect={false}
                            label={"Student Id"}
                            placeholder={"1,2,3"}
                            dataUrl='/reports/studentId' ></AutoCompleteSelect >
                    </div>

                </Box>
            </div>


            <div className="list-table">
                <TableMain listParams={listParamsD}></TableMain>
            </div>
        </>

    )
}