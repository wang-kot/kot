//TODO 在其他页面刷新 关键词载入位置不正常
/**
 * 获取画布的中心点坐标
 @method getCenterPoint
 @param {HTMLDOMElement} DOMElement 通常是一个div
 @return {array} [x, y] 包含中心点坐标的数组
 */
function getCenterPoint(DOMElement) {
    var rect = DOMElement.getBoundingClientRect();
    var rectTop = rect.top;
    var rectLeft = rect.left;
    // var ngx = Math.ceil(rectLeft + rect.width);
    // var ngy = Math.ceil(rectTop + rect.height);
    // // console.log(ngx+":"+ngy);
    // //    var center = [(ngx / 2) + rectLeft, (ngy / 2) + rectTop];
    // var center = [rectLeft+rect.width / 2, rectTop+rect.height / 2];
    var ngx = Math.ceil(rect.width);
    var ngy = Math.ceil(rect.height);
    var center = [(ngx / 2), (ngy / 2)];
    // console.log('rect', rect);
    return center;
}

// var tagCanvas = document.getElementById('html-canvas');
// console.log("所选DOM的中心点为",getCenterPoint(tagCanvas));

// 获取最大半径
function getMaxRadius(DOMElement, cellSpace) {
    var cellSpace = cellSpace || 1;
    var rect = DOMElement.getBoundingClientRect();
    var ngx = Math.ceil(rect.width / cellSpace / 2);
    var ngy = Math.ceil(rect.height / cellSpace / 2);
    var minR = Math.min(ngx, ngy);
    var maxRadius = Math.floor(Math.sqrt(ngx * ngx + ngy * ngy));

    return maxRadius;
}

/**
 * 获取圆上每个点的坐标
 @method getCenterPoint
 @param {int} radius 半径
 @param {array} center 类似[11,22]中心点
 @param {int} offsetY y坐标的偏移位置，默认为1
 @return {array} [x, y] 圆上坐标的数组
 */
function getPointsAtRadius(radius, center, offsetY, multiple) {
    // 因为像素是一个正方形，一个正方形的四周有8块正方形可包围。
    var T = radius * 8;
    var t = T;
    var points = [];
    var offsetY = offsetY || 1;
    var multiple = multiple || 30;

    if (radius === 0) {
        points.push([center[0], center[1]]);
    }
    while (t) {
        // 参考http://www.cnblogs.com/xieon1986/archive/2013/01/28/2880367.html
        // 圆上每个点的
        // Y坐标=圆心y坐标 + Math.sin(2*Math.PI / 360) * 半径
        // X坐标=圆心x坐标 + Math.cos(2*Math.PI / 360) * 半径

        // 弧度=(2*PI/360)*角度
        // 基于圆心的x坐标 X坐标=圆心x坐标 + Math.sin((2*Math.PI / 360) * 1) * 半径
        // 这里的T同360°的意义
        points.push(
            [
                center[0] + (radius * multiple) * Math.cos((t * 2 * Math.PI ) / T),
                center[1] + (radius * multiple) * Math.sin((t * 2 * Math.PI ) / T) * offsetY,
            ]
        );

        t = t - 1;
    }

    return points;
}

// console.log('圆上各点坐标', getPointsAtRadius(1,[731.5, 475]));

/**
 * 获取文本的宽高
 @method getCenterPoint
 @param {HTMLDOMElement} DOMElement 通常是一个div
 @return {array} [x, y] 包含中心点坐标的数组
 */
function getTextInfo(word, userCSS) {
    var fontSize = getRandomFontSize();
    if (userCSS) {
        fontSize = userCSS.fontSize;
    }

    // 通过canvas的API来获取文本的各种信息
    var fcanvas = document.createElement('canvas');
    var fctx = fcanvas.getContext('2d');

    fctx.font = 'normal ' + fontSize + 'px Hiragino Mincho Pro, serif';

    // 通过canvas的measureText方法获取文本 像素级别的宽度
    // http://www.w3school.com.cn/tags/canvas_measuretext.asp
    var fw = fctx.measureText(word).width;
    // 通过字体大小获取高度
    var fh = fontSize;

    return {
        width: Math.ceil(fw),
        height: fh,
        word: word,
        fontSize: fontSize
    }
}

// console.log('你输入的文字长宽为', getTextInfo('你好'));

/**
 * 判断两个矩形是否相交
 * 参考：http://www.cnblogs.com/avril/archive/2012/11/13/2767577.html
 * http://www.cnblogs.com/avril/archive/2013/04/01/2993875.html
 @method isCorssRect
 @param {array}
 @param {array}
 @return {bool} true表示有重叠，false表示没有重叠
 */
function isCorssRect(array1, array2) {
    var Xa1 = array1[0][0];
    var Ya1 = array1[0][1];
    var Xa2 = array1[1][0];
    var Ya2 = array1[1][1];

    var Xb1 = array2[0][0];
    var Yb1 = array2[0][1];
    var Xb2 = array2[1][0];
    var Yb2 = array2[1][1];

    var Xc1 = Math.max(Xa1, Xb1);
    var Yc1 = Math.max(Ya1, Yb1);
    var Xc2 = Math.min(Xa2, Xb2);
    var Yc2 = Math.min(Ya2, Yb2);

    return (Xc1 <= Xc2 && Yc1 <= Yc2);
}


//获取随机颜色的值
function getRandomColor() {
    var arr = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 'A', 'B', 'C', 'D', 'E', 'F'];
    var color = "#";
    for (i = 0; i < 6; i++) {
        var c = parseInt(Math.random() * 16);
        c = arr[c];
        color = color + c;
    }
    return color;
}

// 获取随机文字的大小
function getRandomFontSize() {
    var arr = [14, 15, 17, 20, 18, 12];
//        var res = [];
//        for (var i = 0, len = arr.length; i < len; i++) {
//            var j = Math.floor(Math.random() * arr.length);
//            res[i] = arr[j];
//            arr.splice(j, 1);
//        }

//        return res[0];
    return arr[Math.floor(Math.random() * arr.length)];
}

function drawText(position, textInfo, canvas, href) {
    var span = document.createElement('span');
    var styleRules = {
        'position': 'absolute',
        'display': 'block',
        'font': 'normal' + ' ' + textInfo.fontSize + 'px ' + 'Hiragino Mincho Pro, serif',
        'left': position[0] + 'px',
        'top': position[1] + 'px',
        'width': textInfo.width + 'px',
        'height': textInfo.height + 'px',
        'lineHeight': 1,
        'color': getRandomColor(),
    };
    span.textContent = textInfo.word;
    span.setAttribute("href",href);
    for (var cssProp in styleRules) {
        span.style[cssProp] = styleRules[cssProp];
    }
    canvas.appendChild(span);
}

/**
 * 获取文本的左上右下坐标，
 @param {array} topLeft 类似
 @return {object} textInfo 包含中心点坐标的数组
 */
function getTopLeft(topLeft, textInfo) {
    var left1 = topLeft[0];
    var top1 = topLeft[1];

    return [
        [left1, top1],
        [left1 + textInfo[0], top1 + textInfo[1]]
    ];
}


// 获取可安置的坐标
function getDrawPosition(textInfo, maxRadius, center, cellSpace, drawArray) {
    var textInfo_width = textInfo.width;
    var textInfo_height = textInfo.height;
    var cellSpace = cellSpace || 10;
    for (var i = 0; i < maxRadius; i++) {
        var points = getPointsAtRadius(i, center, 0.64, cellSpace);
        pointsLoop:
            for (var j = 0; j < points.length; j++) {
                var topLeft = getTopLeft(points[j], [textInfo_width, textInfo_height]);
                // 是否和已存的文字碰撞
                for (var z = 0; z < drawArray.length; z++) {
                    if (isCorssRect(topLeft, drawArray[z])) {
                        continue pointsLoop;
                    }

                }
                drawArray.push(topLeft);
                return points[j];
            }
    }
    return null;
}


function start(tagCanvas) {
    // var tagCanvas = document.getElementById('hotKeywordsContent');
    // var center = getCenterPoint(tagCanvas);
    var $tagCanvas = $(tagCanvas);
    var center = getCenterPoint(tagCanvas);
    // console.log(tagCanvas);
    // console.log(center);
    var cellSpace = 20;
    var maxRadius = getMaxRadius(tagCanvas, cellSpace);
    // var data = ["紅樓夢","賈寶玉","林黛玉","薛寶釵","王熙鳳","李紈","賈元春","賈迎春","賈探春","賈惜春","秦可卿","賈巧姐","史湘雲","妙玉","賈政","賈赦","賈璉","賈珍","賈環","賈母","王夫人","薛姨媽","尤氏","平兒","鴛鴦","襲人","晴雯","香菱","紫鵑","麝月","小紅","金釧","甄士隱","賈雨村"];
    // console.log("开始data赋值");
    // console.log($tagCanvas);
    var aS = $tagCanvas.find("a");
    var data = new Array();
    aS.each(function () {
        // console.log($(this));
        // console.log($(this).attr("href"));
        // console.log($(this).html());
        data.push($(this).text()+"-"+$(this).attr("href"));
    })
    // $tagCanvas.find("a").each(function () {
    //     data.push($(this).text());
    //     console.log(data);
    // }

    var drawArray = [];
    var tempDrawPositionArray = [];

    for (var i = 0; i < data.length; i++) {
        var dataCut = data[i].indexOf("-");
        var dataItem = data[i].substring(0,dataCut);
        var dataHref = data[i].substring(dataCut+1);
        var textInfo = getTextInfo(dataItem);
        var drawPosition = null;

        if (i != 0) {
            drawPosition = getDrawPosition(textInfo, maxRadius, center, cellSpace, drawArray);
        }
        else {
            textInfo = getTextInfo(dataItem, {fontSize: 60});
            drawPosition = getDrawPosition(
                textInfo,
                maxRadius,
                [center[0] - (textInfo.width / 2), center[1] - (textInfo.height / 2)],
                cellSpace,
                drawArray
            );
        }

        if (drawPosition) {
            tempDrawPositionArray.push([drawPosition, textInfo, tagCanvas, dataHref]);
        }

    }
    var timer = setInterval(function () {
        var textItem = tempDrawPositionArray.shift();
        if (textItem) {
            drawText(textItem[0], textItem[1], textItem[2], textItem[3]);
        }
        else {
            clearInterval(timer);
        }
    }, 0);


}
//初始化热门关键词
var hotKeywordsContent = document.getElementById("homeHotKeywordsContent");
start(hotKeywordsContent);
//初始化热门教师
var hotTeacherContent = document.getElementById("homeHotTeacherContent");
start(hotTeacherContent);