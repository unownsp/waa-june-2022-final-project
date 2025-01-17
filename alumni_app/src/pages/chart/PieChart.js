import React, { useEffect, useState } from "react";
import ReactECharts from "echarts-for-react";
import { getRequest } from "../../setup/fetch-manager/FetchGateway";

function PieChart(props) {
  let [listData, setListData] = useState();

  const fetchData = async () => {
    let response = await getRequest(props.dataUrl);
    setListData(response);
  };
  useEffect(() => {
    fetchData();
  }, [props]);

  let countVal = 0;
  let result = [];
  if (listData != undefined) {
    result.push(
      <ReactECharts
        key={countVal++}
        option={{
          title: {
            text: "",
            subtext: props.subtext,
            left: "center",
          },
          tooltip: {
            trigger: "item",
          },
          legend: {
            orient: "vertical",
            left: "left",
          },
          series: [
            {
              name: props.name,
              type: "pie",
              radius: "50%",
              data: listData,
              emphasis: {
                itemStyle: {
                  shadowBlur: 10,
                  shadowOffsetX: 0,
                  shadowColor: "rgba(0, 0, 0, 0.5)",
                },
              },
            },
          ],
        }}
      />
    );
  }

  return (
    <>
      <div className="text-center">
        <strong> {props.title}</strong>
      </div>
      {result}
    </>
  );
}
export default PieChart;
