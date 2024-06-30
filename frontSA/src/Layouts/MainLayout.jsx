import React from 'react'
import Navbar from '../components/indusphere/Navbar'
import Sidebar from '../components/indusphere/Sidebar'


export default function MainLayout({ children }) {

    return (
        <>
            <Sidebar/>
            <Navbar/>
            <div className='main-container'>
                <div className='content'>
                    {children}
                </div>
            </div>
        </>
    )
}
