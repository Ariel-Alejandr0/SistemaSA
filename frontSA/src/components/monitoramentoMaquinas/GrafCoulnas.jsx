import React from "react";
import ReactApexChart from "react-apexcharts";

class GrafColunas extends React.Component {
  constructor(props) {
    super(props);

    this.state = {
      series: [{
        data: props.data || []
      }],
      options: {
        chart: {
          type: 'bar',
          height: 350
        },
        plotOptions: {
          bar: {
            borderRadius: 4,
            borderRadiusApplication: 'end',
            horizontal: true,
          }
        },
        dataLabels: {
          enabled: false
        },
        xaxis: {
          categories: props.categories || [],
        }
      }
    };
  }

  componentDidUpdate(prevProps) {
    if (prevProps.data !== this.props.data || prevProps.categories !== this.props.categories) {
      this.setState({
        series: [{
          data: this.props.data
        }],
        options: {
          ...this.state.options,
          xaxis: {
            categories: this.props.categories
          }
        }
      });
    }
  }

  render() {
    return (
      <div>
        <div id="chart">
          <ReactApexChart options={this.state.options} series={this.state.series} type="bar" height={350} />
        </div>
        <div id="html-dist"></div>
      </div>
    );
  }
}

export default GrafColunas;
