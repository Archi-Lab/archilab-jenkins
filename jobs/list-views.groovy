listView('prox') {
    jobs {
        regex('prox.*')
    }
    columns {
        status()
        weather()
        name()
        lastSuccess()
        lastFailure()
        lastDuration()
        buildButton()
    }
}

// listView('coalbase') {
//     jobs {
//         regex('coalbase.*')
//     }
//     columns {
//         status()
//         weather()
//         name()
//         lastSuccess()
//         lastFailure()
//         lastDuration()
//         buildButton()
//     }
// }

listView('fae') {
    jobs {
        regex('fae.*')
    }
    columns {
        status()
        weather()
        name()
        lastSuccess()
        lastFailure()
        lastDuration()
        buildButton()
    }
}
