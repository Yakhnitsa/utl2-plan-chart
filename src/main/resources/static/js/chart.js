var chartApi = Vue.resource('/chart/rest{/id}');
var stationsApi = Vue.resource('/stations-list');

Vue.component('plan-chart',{
    props:['orders','currentPeriod'],
    template:
        '<div class="container-fluid table-responsive">' +
            '<h5>{{currentPeriod}}</h5>' +
            '<table class="table-sm table-striped table-hover">' +
                '<thead class="thead-dark">' +
                    '<tr>' +
                        '<th>ст. Отправления</th>' +
                        '<th>ст. Назначения</th>' +
                        '<th>Описание</th>' +
                    '</tr>' +
                '</thead>'+
                '<tbody>' +
                    '<chart-row v-for="order in orders" :key="order.id" :order="order"/>' +
                '</tbody>'+
            '</table>' +
        '</div>',
    created: function () {
        chartApi.get().then(result =>
        result.json().then(data => {
            chart.currentPeriod = new Date(data.currentPeriod);
            data.orderList.forEach(order => this.orders.push(order));
        }));
    },
});

Vue.component('chart-row',{
    props:['order'],
    data: function(){
        return{
            editable: false
        }
    },
    template:'<tr>' +
            '<td>' +
                '<div class="text-nowrap">' +
                    '<span>{{order.sendStation.code}}<br></span>' +
                    '<span class="small">{{order.sendStation.rusName}}</span>' +
                '</div>'+
            '</td>' +
            '<td>' +
                '<div class="text-nowrap">' +
                    '{{order.receiveStation.code}}<br>' +
                    '{{order.receiveStation.rusName}}' +
                '</div>'+
            '</td>' +
            '<td>{{order.note}}</td>' +
            '<td>' +
                '<input type="button" value="edit" @click="edit"/>' +
                '<input type="button" value="save" @click="save" :disabled ="!editable"/>' +
            '</td>' +
            // '<td>{{row.elements}}</td>' +
            '<chart-cell v-for="element in order.chartElements" :key="element.id" :element="element" :editable="editable"/>' +
        '</tr>',
    methods:{
        edit: function(){
            console.log(this.editable);
            this.editable = true;

        },
        save: function(){
            // this.row.editable = true;
            console.log(this.editable);
            this.editable = false;
            chartApi.save({},this.order).then( result => console.log(result))
        }
    }
});
//
Vue.component('chart-cell',{
    props:['element','editable'],
    data: function(){
        return{
            confirmed:'',
            declared:'',
            shipped:''
        }
    },
    template:'<td><span>{{element.confirmed}}</span><input type="text" v-model="element.declared" :disabled ="!editable"/><hr/> ' +
            '<input type="text" v-model="element.shipped" :disabled ="!editable"/>' +
        '</td>',
    methods:{
        convertTimezone: function (day) {
            var convertedDay = day.toLocaleString("en-US", {timeZone: "Europe/Helsinki"});
            convertedDay = new Date(convertedDay);
            return convertedDay.toLocaleString();
        }
    }
});
var stations = [];
{
    console.log("some function called");
    loadStations();
}

function loadStations(){
    console.log('Loading stations....');
    stationsApi.get().then(result =>
        result.json().then(stationsList =>{
            stationsList.forEach(station => stations.push(station));
        }))
}

var station = new Vue({
    el: '#station',
    data: {
        receiveStation: {code:'', rusName:'',ukrName:'',administration:'',railDepartment:'',node:''},
        stationSearch:'',
        filteredStations:[]
    },
    watch:{
        stationSearch: function(val){
            if(val.length < 3 ) return;

            var filterArray = stations.filter(station => checkStation(val,station));
            console.log(stations.length);
            console.log(filterArray.length);
            if(filterArray.length == 1){

                this.receiveStation = filterArray[0];
                this.filteredStations = null;
                this.stationSearch = this.receiveStation.code;
            }else{
                this.filteredStations = filterArray;
            }


        }
    }
});

function checkStation(patt,station){
    var regexp = new RegExp(patt,"i");
    return regexp.test(station.code) || regexp.test(station.rusName);
}


var chart = new Vue({
    el: '#chart',
    template: '<plan-chart :orders="orders" :currentPeriod="currentPeriod"/>',
    data: {
        orders:[],
        currentPeriod:''
    },
});



// Прикладные функции:
function daysInMonth(date) {
    return 33 - new Date(date.getFullYear(), date.getMonth(), 33).getDate();
}