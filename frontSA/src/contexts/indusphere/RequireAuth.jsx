import React, { useContext, useEffect } from 'react'
import { AuthCtx } from './Auth'
import { Outlet, useNavigate } from 'react-router-dom';
import MainLayout from '../../Layouts/MainLayout';

export default function RequireAuth() {
  const auth = useContext(AuthCtx)
  const navigate = useNavigate()
  useEffect(() => {
    if(!auth.user) {
        navigate('/login')
    }
  }, [])

  return auth.user 
  ? 
  <MainLayout>
    <Outlet/>
  </MainLayout> 
  : null
}
