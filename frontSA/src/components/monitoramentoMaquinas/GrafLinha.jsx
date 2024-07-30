import React from "react";
import ReactApexChart from "react-apexcharts";

class GrafLinha extends React.Component {
  constructor(props) {
    super(props);

    this.state = {
      series: [{
        name: "OEE",
        data: props.oees || []
      }],
      options: {
        chart: {
          height: 350,
          type: 'line',
          zoom: {
            enabled: false
          }
        },
        dataLabels: {
          enabled: false
        },
        stroke: {
          curve: 'straight'
        },
        title: {
          text: '',
          align: 'left'
        },
        grid: {
          row: {
            colors: ['#f3f3f3', 'transparent'], // takes an array which will be repeated on columns
            opacity: 0.5
          }
        },
        xaxis: {
          categories: props.dias || [],
        }
      }
    };
  }

  componentDidUpdate(prevProps) {
    if (prevProps.oees !== this.props.oees || prevProps.dias !== this.props.dias) {
      this.setState({
        series: [{ name: "OEE", data: this.props.oees }],
        options: {
          ...this.state.options,
          xaxis: {
            categories: this.props.dias
          }
        }
      });
    }
  }

  render() {
    return (
      <div>
        <div id="chart">
          <ReactApexChart options={this.state.options} series={this.state.series} type="line" height={350} />
        </div>
        <div id="html-dist"></div>
      </div>
    );
  }
}

export default GrafLinha;
