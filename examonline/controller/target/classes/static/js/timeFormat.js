function formatTimeFromTimestamp(timestamp) {   
    return new Date(parseInt(timestamp) * 1000).toLocaleString().replace(/年|月/g, "-").replace(/日/g, " ");    
 }