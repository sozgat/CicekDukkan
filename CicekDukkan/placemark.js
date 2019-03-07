ymaps.ready(init);

	function init() {
	    var myMap = new ymaps.Map("map", {
	            center: [41.064028, 29.027323],
	            zoom: 14
	        }, {
	            searchControlProvider: 'yandex#search'
	        }),

	    // Creating a geo object with the "Point" geometry type.
	        myGeoObject = new ymaps.GeoObject({ }, {})
	        myMap.geoObjects

	        .add(new ymaps.Placemark([41.04903,29.02341], {
	            balloonContent: '199',
	            iconCaption: '199'
	        }, {
	        	preset: 'islands#blueCircleDotIconWithCaption',
	            iconColor: '#0000ff'
	        }))
	        .add(new ymaps.Placemark([41.04859,29.02157], {
	            balloonContent: '191',
	            iconCaption: '191'
	        }, {
	        	preset: 'islands#blueCircleDotIconWithCaption',
	            iconColor: '#0000ff'
	        }))
	        .add(new ymaps.Placemark([41.04858,29.02125], {
	            balloonContent: '152',
	            iconCaption: '152'
	        }, {
	        	preset: 'islands#blueCircleDotIconWithCaption',
	            iconColor: '#0000ff'
	        }))
	        .add(new ymaps.Placemark([41.05461,29.0274], {
	            balloonContent: '140',
	            iconCaption: '140'
	        }, {
	        	preset: 'islands#blueCircleDotIconWithCaption',
	            iconColor: '#0000ff'
	        }))
	        .add(new ymaps.Placemark([41.05221,29.03323], {
	            balloonContent: '107',
	            iconCaption: '107'
	        }, {
	        	preset: 'islands#blueCircleDotIconWithCaption',
	            iconColor: '#0000ff'
	        }))
	        .add(new ymaps.Placemark([41.05434,29.03172], {
	            balloonContent: '115',
	            iconCaption: '115'
	        }, {
	        	preset: 'islands#blueCircleDotIconWithCaption',
	            iconColor: '#0000ff'
	        }))
	        .add(new ymaps.Placemark([41.05718,29.03047], {
	            balloonContent: '176',
	            iconCaption: '176'
	        }, {
	        	preset: 'islands#blueCircleDotIconWithCaption',
	            iconColor: '#0000ff'
	        }))
	        .add(new ymaps.Placemark([41.05797,29.01616], {
	            balloonContent: '148',
	            iconCaption: '148'
	        }, {
	        	preset: 'islands#blueCircleDotIconWithCaption',
	            iconColor: '#0000ff'
	        }))
	        .add(new ymaps.Placemark([41.04615,29.01204], {
	            balloonContent: '113',
	            iconCaption: '113'
	        }, {
	        	preset: 'islands#blueCircleDotIconWithCaption',
	            iconColor: '#ff0000'
	        }))
	        .add(new ymaps.Placemark([41.05695,29.01231], {
	            balloonContent: '161',
	            iconCaption: '161'
	        }, {
	        	preset: 'islands#blueCircleDotIconWithCaption',
	            iconColor: '#ff0000'
	        }))
	        .add(new ymaps.Placemark([41.04713,29.00911], {
	            balloonContent: '126',
	            iconCaption: '126'
	        }, {
	        	preset: 'islands#blueCircleDotIconWithCaption',
	            iconColor: '#ff0000'
	        }))
	        .add(new ymaps.Placemark([41.04378,29.00996], {
	            balloonContent: '133',
	            iconCaption: '133'
	        }, {
	        	preset: 'islands#blueCircleDotIconWithCaption',
	            iconColor: '#ff0000'
	        }))
	        .add(new ymaps.Placemark([41.0438,29.00998], {
	            balloonContent: '143',
	            iconCaption: '143'
	        }, {
	        	preset: 'islands#blueCircleDotIconWithCaption',
	            iconColor: '#ff0000'
	        }))
	        .add(new ymaps.Placemark([41.05928,29.01205], {
	            balloonContent: '138',
	            iconCaption: '138'
	        }, {
	        	preset: 'islands#blueCircleDotIconWithCaption',
	            iconColor: '#ff0000'
	        }))
	        .add(new ymaps.Placemark([41.05208,29.00721], {
	            balloonContent: '174',
	            iconCaption: '174'
	        }, {
	        	preset: 'islands#blueCircleDotIconWithCaption',
	            iconColor: '#ff0000'
	        }))
	        .add(new ymaps.Placemark([41.06177,29.03788], {
	            balloonContent: '117',
	            iconCaption: '117'
	        }, {
	        	preset: 'islands#blueCircleDotIconWithCaption',
	            iconColor: '#0000ff'
	        }))
	        .add(new ymaps.Placemark([41.05182,29.00597], {
	            balloonContent: '172',
	            iconCaption: '172'
	        }, {
	        	preset: 'islands#blueCircleDotIconWithCaption',
	            iconColor: '#ff0000'
	        }))
	        .add(new ymaps.Placemark([41.06072,29.01134], {
	            balloonContent: '110',
	            iconCaption: '110'
	        }, {
	        	preset: 'islands#blueCircleDotIconWithCaption',
	            iconColor: '#0000ff'
	        }))
	        .add(new ymaps.Placemark([41.06078,29.01083], {
	            balloonContent: '101',
	            iconCaption: '101'
	        }, {
	        	preset: 'islands#blueCircleDotIconWithCaption',
	            iconColor: '#ff0000'
	        }))
	        .add(new ymaps.Placemark([41.0608,29.010849999999998], {
	            balloonContent: '150',
	            iconCaption: '150'
	        }, {
	        	preset: 'islands#blueCircleDotIconWithCaption',
	            iconColor: '#0000ff'
	        }))
	        .add(new ymaps.Placemark([41.06082,29.010869999999997], {
	            balloonContent: '155',
	            iconCaption: '155'
	        }, {
	        	preset: 'islands#blueCircleDotIconWithCaption',
	            iconColor: '#0000ff'
	        }))
	        .add(new ymaps.Placemark([41.06084,29.010889999999996], {
	            balloonContent: '188',
	            iconCaption: '188'
	        }, {
	        	preset: 'islands#blueCircleDotIconWithCaption',
	            iconColor: '#0000ff'
	        }))
	        .add(new ymaps.Placemark([41.06195,29.01185], {
	            balloonContent: '183',
	            iconCaption: '183'
	        }, {
	        	preset: 'islands#blueCircleDotIconWithCaption',
	            iconColor: '#00ff00'
	        }))
	        .add(new ymaps.Placemark([41.05842,29.0072], {
	            balloonContent: '173',
	            iconCaption: '173'
	        }, {
	        	preset: 'islands#blueCircleDotIconWithCaption',
	            iconColor: '#ff0000'
	        }))
	        .add(new ymaps.Placemark([41.05334,29.00382], {
	            balloonContent: '184',
	            iconCaption: '184'
	        }, {
	        	preset: 'islands#blueCircleDotIconWithCaption',
	            iconColor: '#ff0000'
	        }))
	        .add(new ymaps.Placemark([41.06307,29.01096], {
	            balloonContent: '141',
	            iconCaption: '141'
	        }, {
	        	preset: 'islands#blueCircleDotIconWithCaption',
	            iconColor: '#00ff00'
	        }))
	        .add(new ymaps.Placemark([41.06309,29.01098], {
	            balloonContent: '164',
	            iconCaption: '164'
	        }, {
	        	preset: 'islands#blueCircleDotIconWithCaption',
	            iconColor: '#00ff00'
	        }))
	        .add(new ymaps.Placemark([41.06311,29.011], {
	            balloonContent: '165',
	            iconCaption: '165'
	        }, {
	        	preset: 'islands#blueCircleDotIconWithCaption',
	            iconColor: '#00ff00'
	        }))
	        .add(new ymaps.Placemark([41.05128,29.0031], {
	            balloonContent: '114',
	            iconCaption: '114'
	        }, {
	        	preset: 'islands#blueCircleDotIconWithCaption',
	            iconColor: '#ff0000'
	        }))
	        .add(new ymaps.Placemark([41.0513,29.00312], {
	            balloonContent: '122',
	            iconCaption: '122'
	        }, {
	        	preset: 'islands#blueCircleDotIconWithCaption',
	            iconColor: '#ff0000'
	        }))
	        .add(new ymaps.Placemark([41.04683,29.00313], {
	            balloonContent: '119',
	            iconCaption: '119'
	        }, {
	        	preset: 'islands#blueCircleDotIconWithCaption',
	            iconColor: '#ff0000'
	        }))
	        .add(new ymaps.Placemark([41.06371,29.01042], {
	            balloonContent: '157',
	            iconCaption: '157'
	        }, {
	        	preset: 'islands#blueCircleDotIconWithCaption',
	            iconColor: '#00ff00'
	        }))
	        .add(new ymaps.Placemark([41.06773,29.02029], {
	            balloonContent: '163',
	            iconCaption: '163'
	        }, {
	        	preset: 'islands#blueCircleDotIconWithCaption',
	            iconColor: '#00ff00'
	        }))
	        .add(new ymaps.Placemark([41.06416,29.00997], {
	            balloonContent: '102',
	            iconCaption: '102'
	        }, {
	        	preset: 'islands#blueCircleDotIconWithCaption',
	            iconColor: '#00ff00'
	        }))
	        .add(new ymaps.Placemark([41.06418,29.00999], {
	            balloonContent: '128',
	            iconCaption: '128'
	        }, {
	        	preset: 'islands#blueCircleDotIconWithCaption',
	            iconColor: '#00ff00'
	        }))
	        .add(new ymaps.Placemark([41.0642,29.010009999999998], {
	            balloonContent: '134',
	            iconCaption: '134'
	        }, {
	        	preset: 'islands#blueCircleDotIconWithCaption',
	            iconColor: '#00ff00'
	        }))
	        .add(new ymaps.Placemark([41.04184,29.00299], {
	            balloonContent: '104',
	            iconCaption: '104'
	        }, {
	        	preset: 'islands#blueCircleDotIconWithCaption',
	            iconColor: '#ff0000'
	        }))
	        .add(new ymaps.Placemark([41.04186,29.00301], {
	            balloonContent: '182',
	            iconCaption: '182'
	        }, {
	        	preset: 'islands#blueCircleDotIconWithCaption',
	            iconColor: '#ff0000'
	        }))
	        .add(new ymaps.Placemark([41.066,29.04069], {
	            balloonContent: '135',
	            iconCaption: '135'
	        }, {
	        	preset: 'islands#blueCircleDotIconWithCaption',
	            iconColor: '#0000ff'
	        }))
	        .add(new ymaps.Placemark([41.06148,29.00481], {
	            balloonContent: '118',
	            iconCaption: '118'
	        }, {
	        	preset: 'islands#blueCircleDotIconWithCaption',
	            iconColor: '#ff0000'
	        }))
	        .add(new ymaps.Placemark([41.04595,28.99986], {
	            balloonContent: '166',
	            iconCaption: '166'
	        }, {
	        	preset: 'islands#blueCircleDotIconWithCaption',
	            iconColor: '#ff0000'
	        }))
	        .add(new ymaps.Placemark([41.0455,28.99978], {
	            balloonContent: '121',
	            iconCaption: '121'
	        }, {
	        	preset: 'islands#blueCircleDotIconWithCaption',
	            iconColor: '#ff0000'
	        }))
	        .add(new ymaps.Placemark([41.045519999999996,28.9998], {
	            balloonContent: '123',
	            iconCaption: '123'
	        }, {
	        	preset: 'islands#blueCircleDotIconWithCaption',
	            iconColor: '#ff0000'
	        }))
	        .add(new ymaps.Placemark([41.05619,28.99996], {
	            balloonContent: '145',
	            iconCaption: '145'
	        }, {
	        	preset: 'islands#blueCircleDotIconWithCaption',
	            iconColor: '#ff0000'
	        }))
	        .add(new ymaps.Placemark([41.0429,29.00004], {
	            balloonContent: '120',
	            iconCaption: '120'
	        }, {
	        	preset: 'islands#blueCircleDotIconWithCaption',
	            iconColor: '#ff0000'
	        }))
	        .add(new ymaps.Placemark([41.07002,29.01765], {
	            balloonContent: '111',
	            iconCaption: '111'
	        }, {
	        	preset: 'islands#blueCircleDotIconWithCaption',
	            iconColor: '#00ff00'
	        }))
	        .add(new ymaps.Placemark([41.06604,29.00737], {
	            balloonContent: '131',
	            iconCaption: '131'
	        }, {
	        	preset: 'islands#blueCircleDotIconWithCaption',
	            iconColor: '#00ff00'
	        }))
	        .add(new ymaps.Placemark([41.06606,29.00739], {
	            balloonContent: '177',
	            iconCaption: '177'
	        }, {
	        	preset: 'islands#blueCircleDotIconWithCaption',
	            iconColor: '#0000ff'
	        }))
	        .add(new ymaps.Placemark([41.06608,29.00741], {
	            balloonContent: '192',
	            iconCaption: '192'
	        }, {
	        	preset: 'islands#blueCircleDotIconWithCaption',
	            iconColor: '#0000ff'
	        }))
	        .add(new ymaps.Placemark([41.0661,29.00743], {
	            balloonContent: '196',
	            iconCaption: '196'
	        }, {
	        	preset: 'islands#blueCircleDotIconWithCaption',
	            iconColor: '#0000ff'
	        }))
	        .add(new ymaps.Placemark([41.05938,29.00036], {
	            balloonContent: '124',
	            iconCaption: '124'
	        }, {
	        	preset: 'islands#blueCircleDotIconWithCaption',
	            iconColor: '#ff0000'
	        }))
	        .add(new ymaps.Placemark([41.06766,29.04305], {
	            balloonContent: '144',
	            iconCaption: '144'
	        }, {
	        	preset: 'islands#blueCircleDotIconWithCaption',
	            iconColor: '#0000ff'
	        }))
	        .add(new ymaps.Placemark([41.0616,29.00046], {
	            balloonContent: '168',
	            iconCaption: '168'
	        }, {
	        	preset: 'islands#blueCircleDotIconWithCaption',
	            iconColor: '#ff0000'
	        }))
	        .add(new ymaps.Placemark([41.06644,29.00427], {
	            balloonContent: '197',
	            iconCaption: '197'
	        }, {
	        	preset: 'islands#blueCircleDotIconWithCaption',
	            iconColor: '#0000ff'
	        }))
	        .add(new ymaps.Placemark([41.06438,29.00136], {
	            balloonContent: '169',
	            iconCaption: '169'
	        }, {
	        	preset: 'islands#blueCircleDotIconWithCaption',
	            iconColor: '#0000ff'
	        }))
	        .add(new ymaps.Placemark([41.07277,29.01666], {
	            balloonContent: '198',
	            iconCaption: '198'
	        }, {
	        	preset: 'islands#blueCircleDotIconWithCaption',
	            iconColor: '#00ff00'
	        }))
	        .add(new ymaps.Placemark([41.06113,28.99808], {
	            balloonContent: '187',
	            iconCaption: '187'
	        }, {
	        	preset: 'islands#blueCircleDotIconWithCaption',
	            iconColor: '#ff0000'
	        }))
	        .add(new ymaps.Placemark([41.07092,29.042], {
	            balloonContent: '129',
	            iconCaption: '129'
	        }, {
	        	preset: 'islands#blueCircleDotIconWithCaption',
	            iconColor: '#00ff00'
	        }))
	        .add(new ymaps.Placemark([41.07438,29.01853], {
	            balloonContent: '185',
	            iconCaption: '185'
	        }, {
	        	preset: 'islands#blueCircleDotIconWithCaption',
	            iconColor: '#00ff00'
	        }))
	        .add(new ymaps.Placemark([41.07565,29.02047], {
	            balloonContent: '189',
	            iconCaption: '189'
	        }, {
	        	preset: 'islands#blueCircleDotIconWithCaption',
	            iconColor: '#00ff00'
	        }))
	        .add(new ymaps.Placemark([41.07435,29.03925], {
	            balloonContent: '171',
	            iconCaption: '171'
	        }, {
	        	preset: 'islands#blueCircleDotIconWithCaption',
	            iconColor: '#00ff00'
	        }))
	        .add(new ymaps.Placemark([41.05175,28.99054], {
	            balloonContent: '137',
	            iconCaption: '137'
	        }, {
	        	preset: 'islands#blueCircleDotIconWithCaption',
	            iconColor: '#ff0000'
	        }))
	        .add(new ymaps.Placemark([41.05243,28.99045], {
	            balloonContent: '156',
	            iconCaption: '156'
	        }, {
	        	preset: 'islands#blueCircleDotIconWithCaption',
	            iconColor: '#ff0000'
	        }))
	        .add(new ymaps.Placemark([41.07595,29.01577], {
	            balloonContent: '142',
	            iconCaption: '142'
	        }, {
	        	preset: 'islands#blueCircleDotIconWithCaption',
	            iconColor: '#00ff00'
	        }))
	        .add(new ymaps.Placemark([41.07708,29.03119], {
	            balloonContent: '125',
	            iconCaption: '125'
	        }, {
	        	preset: 'islands#blueCircleDotIconWithCaption',
	            iconColor: '#00ff00'
	        }))
	        .add(new ymaps.Placemark([41.0771,29.031209999999998], {
	            balloonContent: '147',
	            iconCaption: '147'
	        }, {
	        	preset: 'islands#blueCircleDotIconWithCaption',
	            iconColor: '#00ff00'
	        }))
	        .add(new ymaps.Placemark([41.07736,29.03097], {
	            balloonContent: '151',
	            iconCaption: '151'
	        }, {
	        	preset: 'islands#blueCircleDotIconWithCaption',
	            iconColor: '#00ff00'
	        }))
	        .add(new ymaps.Placemark([41.05367,28.98939], {
	            balloonContent: '159',
	            iconCaption: '159'
	        }, {
	        	preset: 'islands#blueCircleDotIconWithCaption',
	            iconColor: '#ff0000'
	        }))
	        .add(new ymaps.Placemark([41.07684,29.01543], {
	            balloonContent: '160',
	            iconCaption: '160'
	        }, {
	        	preset: 'islands#blueCircleDotIconWithCaption',
	            iconColor: '#00ff00'
	        }))
	        .add(new ymaps.Placemark([41.076859999999996,29.015449999999998], {
	            balloonContent: '167',
	            iconCaption: '167'
	        }, {
	        	preset: 'islands#blueCircleDotIconWithCaption',
	            iconColor: '#00ff00'
	        }))
	        .add(new ymaps.Placemark([41.076879999999996,29.015469999999997], {
	            balloonContent: '190',
	            iconCaption: '190'
	        }, {
	        	preset: 'islands#blueCircleDotIconWithCaption',
	            iconColor: '#00ff00'
	        }))
	        .add(new ymaps.Placemark([41.07888,29.03018], {
	            balloonContent: '162',
	            iconCaption: '162'
	        }, {
	        	preset: 'islands#blueCircleDotIconWithCaption',
	            iconColor: '#00ff00'
	        }))
	        .add(new ymaps.Placemark([41.07891,29.02122], {
	            balloonContent: '175',
	            iconCaption: '175'
	        }, {
	        	preset: 'islands#blueCircleDotIconWithCaption',
	            iconColor: '#00ff00'
	        }))
	        .add(new ymaps.Placemark([41.07826,29.01577], {
	            balloonContent: '100',
	            iconCaption: '100'
	        }, {
	        	preset: 'islands#blueCircleDotIconWithCaption',
	            iconColor: '#00ff00'
	        }))
	        .add(new ymaps.Placemark([41.07828,29.01579], {
	            balloonContent: '116',
	            iconCaption: '116'
	        }, {
	        	preset: 'islands#blueCircleDotIconWithCaption',
	            iconColor: '#00ff00'
	        }))
	        .add(new ymaps.Placemark([41.053072478048,28.987209066283], {
	            balloonContent: '153',
	            iconCaption: '153'
	        }, {
	        	preset: 'islands#blueCircleDotIconWithCaption',
	            iconColor: '#ff0000'
	        }))
	        .add(new ymaps.Placemark([41.05689,28.98713], {
	            balloonContent: '170',
	            iconCaption: '170'
	        }, {
	        	preset: 'islands#blueCircleDotIconWithCaption',
	            iconColor: '#ff0000'
	        }))
	        .add(new ymaps.Placemark([41.07998,29.02133], {
	            balloonContent: '127',
	            iconCaption: '127'
	        }, {
	        	preset: 'islands#blueCircleDotIconWithCaption',
	            iconColor: '#00ff00'
	        }))
	        .add(new ymaps.Placemark([41.078476490079,29.009396156746], {
	            balloonContent: '193',
	            iconCaption: '193'
	        }, {
	        	preset: 'islands#blueCircleDotIconWithCaption',
	            iconColor: '#00ff00'
	        }))
	        .add(new ymaps.Placemark([41.07937,29.01159], {
	            balloonContent: '194',
	            iconCaption: '194'
	        }, {
	        	preset: 'islands#blueCircleDotIconWithCaption',
	            iconColor: '#00ff00'
	        }))
	        .add(new ymaps.Placemark([41.08044,29.01554], {
	            balloonContent: '186',
	            iconCaption: '186'
	        }, {
	        	preset: 'islands#blueCircleDotIconWithCaption',
	            iconColor: '#00ff00'
	        }))
	        .add(new ymaps.Placemark([41.07922,29.01044], {
	            balloonContent: '139',
	            iconCaption: '139'
	        }, {
	        	preset: 'islands#blueCircleDotIconWithCaption',
	            iconColor: '#00ff00'
	        }))
	        .add(new ymaps.Placemark([41.08052,29.01224], {
	            balloonContent: '112',
	            iconCaption: '112'
	        }, {
	        	preset: 'islands#blueCircleDotIconWithCaption',
	            iconColor: '#00ff00'
	        }))
	        .add(new ymaps.Placemark([41.07919,29.04516], {
	            balloonContent: '146',
	            iconCaption: '146'
	        }, {
	        	preset: 'islands#blueCircleDotIconWithCaption',
	            iconColor: '#00ff00'
	        }))
	        .add(new ymaps.Placemark([41.08117,29.0398], {
	            balloonContent: '108',
	            iconCaption: '108'
	        }, {
	        	preset: 'islands#blueCircleDotIconWithCaption',
	            iconColor: '#00ff00'
	        }))
	        .add(new ymaps.Placemark([41.08085,29.01036], {
	            balloonContent: '132',
	            iconCaption: '132'
	        }, {
	        	preset: 'islands#blueCircleDotIconWithCaption',
	            iconColor: '#00ff00'
	        }))
	        .add(new ymaps.Placemark([41.08329,29.02852], {
	            balloonContent: '158',
	            iconCaption: '158'
	        }, {
	        	preset: 'islands#blueCircleDotIconWithCaption',
	            iconColor: '#00ff00'
	        }))
	        .add(new ymaps.Placemark([41.0831,29.01515], {
	            balloonContent: '154',
	            iconCaption: '154'
	        }, {
	        	preset: 'islands#blueCircleDotIconWithCaption',
	            iconColor: '#00ff00'
	        }))
	        .add(new ymaps.Placemark([41.08322,29.01363], {
	            balloonContent: '130',
	            iconCaption: '130'
	        }, {
	        	preset: 'islands#blueCircleDotIconWithCaption',
	            iconColor: '#00ff00'
	        }))
	        .add(new ymaps.Placemark([41.08368,29.01499], {
	            balloonContent: '179',
	            iconCaption: '179'
	        }, {
	        	preset: 'islands#blueCircleDotIconWithCaption',
	            iconColor: '#00ff00'
	        }))
	        .add(new ymaps.Placemark([41.08465,29.02061], {
	            balloonContent: '195',
	            iconCaption: '195'
	        }, {
	        	preset: 'islands#blueCircleDotIconWithCaption',
	            iconColor: '#00ff00'
	        }))
	        .add(new ymaps.Placemark([41.08529,29.01979], {
	            balloonContent: '103',
	            iconCaption: '103'
	        }, {
	        	preset: 'islands#blueCircleDotIconWithCaption',
	            iconColor: '#00ff00'
	        }))
	        .add(new ymaps.Placemark([41.08504,29.01757], {
	            balloonContent: '106',
	            iconCaption: '106'
	        }, {
	        	preset: 'islands#blueCircleDotIconWithCaption',
	            iconColor: '#00ff00'
	        }))
	        .add(new ymaps.Placemark([41.08476,29.01351], {
	            balloonContent: '181',
	            iconCaption: '181'
	        }, {
	        	preset: 'islands#blueCircleDotIconWithCaption',
	            iconColor: '#00ff00'
	        }))
	        .add(new ymaps.Placemark([41.08596,29.03349], {
	            balloonContent: '109',
	            iconCaption: '109'
	        }, {
	        	preset: 'islands#blueCircleDotIconWithCaption',
	            iconColor: '#00ff00'
	        }))
	        .add(new ymaps.Placemark([41.08688,29.01791], {
	            balloonContent: '136',
	            iconCaption: '136'
	        }, {
	        	preset: 'islands#blueCircleDotIconWithCaption',
	            iconColor: '#00ff00'
	        }))
	        .add(new ymaps.Placemark([41.0855,29.00871], {
	            balloonContent: '105',
	            iconCaption: '105'
	        }, {
	        	preset: 'islands#blueCircleDotIconWithCaption',
	            iconColor: '#00ff00'
	        }))
	        .add(new ymaps.Placemark([41.0891,29.03537], {
	            balloonContent: '180',
	            iconCaption: '180'
	        }, {
	        	preset: 'islands#blueCircleDotIconWithCaption',
	            iconColor: '#00ff00'
	        }))
	        .add(new ymaps.Placemark([41.08765,29.00735], {
	            balloonContent: '178',
	            iconCaption: '178'
	        }, {
	        	preset: 'islands#blueCircleDotIconWithCaption',
	            iconColor: '#00ff00'
	        }))
	        .add(new ymaps.Placemark([41.09264,29.01804], {
	            balloonContent: '149',
	            iconCaption: '149'
	        }, {
	        	preset: 'islands#blueCircleDotIconWithCaption',
	            iconColor: '#00ff00'
	        }))
	        .add(new ymaps.Placemark([41.049792,29.003031], {
	            balloonContent: 'Red Store',
	            iconCaption: 'Red Store'
	        }, {
	        	preset: 'islands#glyphIcon',
				iconGlyph: 'hdd',				iconColor: '#000000',	            iconGlyphColor: '#ff0000'
	        }))
	        .add(new ymaps.Placemark([41.06994,29.01925], {
	            balloonContent: 'Green Store',
	            iconCaption: 'Green Store'
	        }, {
	        	preset: 'islands#glyphIcon',
				iconGlyph: 'hdd',				iconColor: '#000000',	            iconGlyphColor: '#00ff00'
	        }))
	        .add(new ymaps.Placemark([41.049997,29.026108], {
	            balloonContent: 'Blue Store',
	            iconCaption: 'Blue Store'
	        }, {
	        	preset: 'islands#glyphIcon',
				iconGlyph: 'hdd',				iconColor: '#000000',	            iconGlyphColor: '#0000ff'
	        }))
	;}