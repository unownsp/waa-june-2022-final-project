import React from "react";

import TableMain from "../../common/TableMain";

export default function Jobs() {
    let jobList = [
        {
            title: 'hello',
            description: 'this is a test data',
            benefits: 'hello this is the benefits',
            companyName: 'name of the companu',
            tags:[
                {
                    id: 1,
                    title: 'android'
                },
                {
                    id: 2,
                    title: 'java spring'
                },
                {
                    id:3,
                    title: 'spring boot'
                }
            ]
        },
        {
            title: 'hello 2',
            description: 'this is a test data',
            benefits: 'hello this is the benefits',
            companyName: 'name of the companu',
            tags:[
                {
                    id: 1,
                    title: 'android'
                },
                {
                    id: 2,
                    title: 'java spring'
                },
                {
                    id:3,
                    title: 'spring boot'
                }
            ]
        }
    ]
    return (
        <div>
            Job List
            <div className="list-table">
                <TableMain dataUrl={'/jobs'}></TableMain>
            </div>
        </div>
    )
}