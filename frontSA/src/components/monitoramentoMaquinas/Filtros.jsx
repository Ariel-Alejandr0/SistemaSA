import React from 'react'

export default function Filtros() {
  return (
    <div className="filter-container">
        <select id="center">
            <option value="generalFactory">Centro de Trabalho: Geral Fábrica</option>
        </select>
        <select id="shift">
            <option value="firstShift">Turno: 1º turno</option>
        </select>
        <select id="period">
            <option value="currentWeek">Período: 01/02/2024 - 08/02/2024</option>
        </select>
    </div>
  )
}
