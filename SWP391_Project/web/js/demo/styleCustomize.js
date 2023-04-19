

function showCalendarMonth(){
    const calendarSearch = document.querySelector(".calendar_search");
    const calendarButton = document.querySelector(".fa-calendar");
    calendarButton.classList.toggle("text-gray-600")
        calendarSearch.classList.toggle("active");
}

//13/3/2023

function numberOfOrders(){
    const ordersSearch = document.querySelector(".orders_search");
    const ordersButton = document.querySelector(".fa-clipboard-list");
    ordersButton.classList.toggle("text-gray-600")
        ordersSearch.classList.toggle("active");
}




function revenueYears(){
    const revenueYears = document.querySelector(".revenue_search");
    const revenueButton = document.querySelector(".fa-dollar-sign");
    revenueButton.classList.toggle("text-gray-600")
    revenueYears.classList.toggle("active");
}


function revenueYearsSecond(){
    const revenueYears = document.querySelector(".revenue_search-second");
    const revenueButton = document.querySelector(".fa-dollar-sign-2");
    revenueButton.classList.toggle("text-gray-600")
    revenueYears.classList.toggle("active");
}