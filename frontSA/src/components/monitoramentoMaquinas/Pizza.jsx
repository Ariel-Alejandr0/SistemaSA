import React from "react";
import ReactApexChart from "react-apexcharts";

class Pizza extends React.Component {
  constructor(props) {
    super(props);

    this.state = {
      series: props.series || [],
      options: {
        chart: {
          width: 380,
          type: 'pie',
        },
        labels: props.labels || [],
        responsive: [{
          breakpoint: 480,
          options: {
            chart: {
              width: 200
            },
            legend: {
              position: 'bottom'
            }
          }
        }]
      }
    };
  }

  componentDidUpdate(prevProps) {
    if (prevProps.series !== this.props.series || prevProps.labels !== this.props.labels) {
      this.setState({
        series: this.props.series,
        options: {
          ...this.state.options,
          labels: this.props.labels
        }
      });
    }
  }

  render() {
    return (
      <div>
        <div id="chart">
          <ReactApexChart options={this.state.options} series={this.state.series} type="pie" width={380} />
        </div>
        <div id="html-dist"></div>
      </div>
    );
  }
}

export default Pizza;
