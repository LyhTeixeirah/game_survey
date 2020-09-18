import React, { useEffect, useState } from 'react'
import { Link } from 'react-router-dom'
import axios from 'axios'
import './styles.css'

import './Pagenation'

import { formatDate } from './helpers'
import { RecordsResponse } from './types'
import Pagination from './Pagenation'

const BASE_URL = "http://localhost:8080"


const Records = () => {
    const [ recordsResponse, setRecordsResponse ] = useState<RecordsResponse>()
    const [ activePage, setActivePage ] = useState(0)

    useEffect(() => {
        axios.get(`${BASE_URL}/records?linesPerPage=12&page=${activePage}`)
        .then(response => setRecordsResponse(response.data))
    }, [activePage])

    const handlePageChange = (index:number) => {
        setActivePage(index)
    }

return(
    <div className="home-container">

        <div className="filters-container records-actions">
            <Link to="/charts">
                <button className="action-filters">
                    statistics
                </button>
            </Link>
        </div>

        <table className="records-table" cellPadding="0" cellSpacing="0">
            <thead>
                <tr>
                    <th>INSTANT</th>
                    <th>NAME</th>
                    <th>AGE</th>
                    <th>PLATFORM</th>
                    <th>GENRE</th>
                    <th>TITLE</th>
                </tr>
            </thead>
            <tbody>
                {recordsResponse?.content.map(record => (
                    <tr key={record.id}>
                    <td>{formatDate(record.moment)} </td>
                    <td> {record.name} </td>
                    <td> {record.age} </td>
                    <td className="text-secondary">{record.gamePlatform}</td>
                    <td> {record.genreName} </td>
                    <td> {record.gameTitle} </td>
                </tr>
                ))}
            </tbody>
        </table>

                    <Pagination 
                        activePage={activePage} 
                        goToPage={handlePageChange} 
                        totalPages={recordsResponse?.totalPages}
                        />

    </div>
    )
}

export default Records