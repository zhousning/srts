/*! SCEditor | (C) 2011-2013, Sam Clarke | sceditor.com/license */
(function(e, t, n) {
	"use strict";
	var o = {
		html: '<!DOCTYPE html><html><head><style>.ie * {min-height: auto !important}</style><meta http-equiv="Content-Type" content="text/html;charset={charset}" /><link rel="stylesheet" type="text/css" href="{style}" /></head><body contenteditable="true"></body></html>',
		toolbarButton: '<a class="sceditor-button sceditor-button-{name}" data-sceditor-command="{name}" unselectable="on"><div unselectable="on">{dispName}</div></a>',
		emoticon: '<img src="{url}" data-sceditor-emoticon="{key}" alt="{key}" title="{tooltip}" />',
		fontOpt: '<a class="sceditor-font-option" href="#" data-font="{font}"><font face="{font}">{font}</font></a>',
		sizeOpt: '<a class="sceditor-fontsize-option" data-size="{size}" href="#"><font size="{size}">{size}</font></a>',
		pastetext: '<div><label for="txt">{label}</label> <textarea cols="20" rows="7" id="txt"></textarea></div><div><input type="button" class="button" value="{insert}" /></div>',
		table: '<div><label for="rows">{rows}</label><input type="text" id="rows" value="2" /></div><div><label for="cols">{cols}</label><input type="text" id="cols" value="2" /></div><div><input type="button" class="button" value="{insert}" /></div>',
		image: '<div><label for="link">{url}</label> <input type="text" id="image" value="http://" /></div><div><label for="width">{width}</label> <input type="text" id="width" size="2" /></div><div><label for="height">{height}</label> <input type="text" id="height" size="2" /></div><div><input type="button" class="button" value="{insert}" /></div>',
		email: '<div><label for="email">{label}</label> <input type="text" id="email" /></div><div><input type="button" class="button" value="{insert}" /></div>',
		link: '<div><label for="link">{url}</label> <input type="text" id="link" value="http://" /></div><div><label for="des">{desc}</label> <input type="text" id="des" /></div><div><input type="button" class="button" value="{ins}" /></div>',
		youtubeMenu: '<div><label for="link">{label}</label> <input type="text" id="link" value="http://" /></div><div><input type="button" class="button" value="{insert}" /></div>',
		youtube: '<iframe width="560" height="315" src="http://www.youtube.com/embed/{id}?wmode=opaque" data-youtube-id="{id}" frameborder="0" allowfullscreen></iframe>'
	},
	i = function(t, n, i) {
		var r = o[t];
		return e.each(n,
		function(e, t) {
			r = r.replace(RegExp("\\{" + e + "\\}", "g"), t)
		}),
		i && (r = e(r)),
		r
	};
	e.sceditor = function(o, r) {
		var s, a, l, c, d, u, p, f, h, m, g, b, v, y, x, w, C, k, E, S, T, D, M, H, R, z, I, O, B, P, N, A, _, L, W, F, j, q, V, $, Q, U, Y, K, X, G, J, Z, et, tt, nt = this,
		ot = o.get ? o.get(0) : o,
		it = e(ot),
		rt = [],
		st = [],
		at = [],
		lt = [],
		ct = {};
		nt.commands = e.extend(!0, {},
		r.commands || e.sceditor.commands),
		nt.opts = r = e.extend({},
		e.sceditor.defaultOptions, r),
		S = function() {
			it.data("sceditor", nt),
			e.each(r,
			function(t, n) {
				e.isPlainObject(n) && (r[t] = e.extend(!0, {},
				n))
			}),
			r.locale && "en" !== r.locale && z(),
			s = e('<div class="sceditor-container" />').insertAfter(it).css("z-index", r.zIndex),
			e.sceditor.ie && s.addClass("ie ie" + e.sceditor.ie),
			k = !!it.attr("required"),
			it.removeAttr("required"),
			R(),
			A(),
			I(),
			H(),
			P(),
			O(),
			B(),
			e.sceditor.isWysiwygSupported || nt.toggleSourceMode();
			var o = function() {
				e(t).unbind("load", o),
				r.autofocus && et(),
				r.autoExpand && nt.expandToContent(),
				U()
			};
			e(t).load(o),
			n.readyState && "complete" === n.readyState && o(),
			K(),
			y.call("ready")
		},
		R = function() {
			var t = r.plugins;
			t = t ? ("" + t).split(",") : [],
			y = new e.sceditor.PluginManager(nt),
			e.each(t,
			function(t, n) {
				y.register(e.trim(n))
			})
		},
		z = function() {
			var t;
			e.sceditor.locale[r.locale] ? g = e.sceditor.locale[r.locale] : (t = r.locale.split("-"), e.sceditor.locale[t[0]] && (g = e.sceditor.locale[t[0]])),
			g && g.dateFormat && (r.dateFormat = g.dateFormat)
		},
		H = function() {
			var n, o;
			p = e("<textarea></textarea>").hide(),
			l = e('<iframe frameborder="0"></iframe>'),
			"https:" === t.location.protocol && l.attr("src", "javascript:false"),
			s.append(l).append(p),
			c = l[0],
			f = p[0],
			nt.width(r.width || it.width()),
			nt.height(r.height || it.height()),
			n = _(),
			n.open(),
			n.write(i("html", {
				charset: r.charset,
				style: r.style
			})),
			n.close(),
			u = e(n),
			d = e(n.body),
			nt.readOnly( !! r.readOnly),
			e.sceditor.ie && u.find("html").addClass("ie ie" + e.sceditor.ie),
			(/iPhone|iPod|iPad| wosbrowser\//i.test(navigator.userAgent) || e.sceditor.ie) && (d.height("100%"), e.sceditor.ie || d.bind("touchend", nt.focus)),
			b = new e.sceditor.rangeHelper(c.contentWindow),
			nt.val(it.hide().val()),
			o = it.attr("tabindex"),
			p.attr("tabindex", o),
			l.attr("tabindex", o)
		},
		O = function() {
			r.autoUpdate && (d.bind("blur", nt.updateOriginal), p.bind("blur", nt.updateOriginal)),
			null === r.rtl && (r.rtl = "rtl" === p.css("direction")),
			nt.rtl( !! r.rtl),
			r.autoExpand && u.bind("keyup", nt.expandToContent),
			r.resizeEnabled && N(),
			s.attr("id", r.id),
			nt.emoticons(r.emoticonsEnabled)
		},
		B = function() {
			e(n).click(Q),
			e(ot.form).bind("reset", q).submit(nt.updateOriginal),
			e(t).bind("resize orientationChanged", U),
			d.keypress(j).keydown(F).keyup(G).bind("paste", L).bind(e.sceditor.ie ? "selectionchange": "keyup focus blur contextmenu mouseup touchend click", J).bind("keydown keyup keypress focus blur contextmenu", $),
			p.bind("keydown keyup keypress focus blur contextmenu", $).keydown(F),
			u.keypress(j).mousedown(V).bind(e.sceditor.ie ? "selectionchange": "focus blur contextmenu mouseup click", J).bind("beforedeactivate keyup", M).keyup(G).focus(function() {
				m = null
			}),
			s.bind("selectionchanged", K).bind("selectionchanged", Z).bind("selectionchanged", $).bind("nodechanged", $)
		},
		I = function() {
			var t, n, o = (r.toolbarExclude || "").split(","),
			l = r.toolbar.split("|");
			a = e('<div class="sceditor-toolbar" unselectable="on" />'),
			e.each(l,
			function(r, s) {
				t = e('<div class="sceditor-group" />'),
				e.each(s.split(","),
				function(r, s) { ! nt.commands[s] || e.inArray(s, o) > -1 || (n = i("toolbarButton", {
						name: s,
						dispName: nt._(nt.commands[s].tooltip || s)
					},
					!0), n.data("sceditor-txtmode", !!nt.commands[s].txtExec), n.data("sceditor-wysiwygmode", !!nt.commands[s].exec), n.click(function() {
						var t = e(this);
						return t.hasClass("disabled") || D(t, nt.commands[s]),
						K(),
						!1
					}), nt.commands[s].tooltip && n.attr("title", nt._(nt.commands[s].tooltip)), nt.commands[s].exec || n.addClass("disabled"), nt.commands[s].shortcut && nt.addShortcut(nt.commands[s].shortcut, s), t.append(n))
				}),
				t[0].firstChild && a.append(t)
			}),
			e(r.toolbarContainer || s).append(a)
		},
		P = function() {
			e.each(nt.commands,
			function(t, n) {
				n.keyPress && rt.push(n.keyPress),
				n.forceNewLineAfter && e.isArray(n.forceNewLineAfter) && (at = e.merge(at, n.forceNewLineAfter)),
				n.state ? lt.push({
					name: t,
					state: n.state
				}) : "string" == typeof n.exec && lt.push({
					name: t,
					state: n.exec
				})
			})
		},
		N = function() {
			var o, i, a, l, c, d, u = e('<div class="sceditor-grip" />'),
			p = e('<div class="sceditor-resize-cover" />'),
			f = 0,
			h = 0,
			m = 0,
			g = 0,
			b = s.width(),
			v = s.height(),
			y = !1,
			x = nt.rtl();
			o = r.resizeMinHeight || v / 1.5,
			i = r.resizeMaxHeight || 2.5 * v,
			a = r.resizeMinWidth || b / 1.25,
			l = r.resizeMaxWidth || 1.25 * b,
			c = function(n) {
				"touchmove" === n.type && (n = t.event);
				var c = g + (n.pageY - h),
				d = x ? m - (n.pageX - f) : m + (n.pageX - f);
				l > 0 && d > l && (d = l),
				i > 0 && c > i && (c = i),
				(!r.resizeWidth || a > d || l > 0 && d > l) && (d = !1),
				(!r.resizeHeight || o > c || i > 0 && c > i) && (c = !1),
				(d || c) && (nt.dimensions(d, c), 7 > e.sceditor.ie && s.height(c)),
				n.preventDefault()
			},
			d = function(t) {
				y && (y = !1, p.hide(), s.removeClass("resizing").height("auto"), e(n).unbind("touchmove mousemove", c), e(n).unbind("touchend mouseup", d), t.preventDefault())
			},
			s.append(u),
			s.append(p.hide()),
			u.bind("touchstart mousedown",
			function(o) {
				"touchstart" === o.type && (o = t.event),
				f = o.pageX,
				h = o.pageY,
				m = s.width(),
				g = s.height(),
				y = !0,
				s.addClass("resizing"),
				p.show(),
				e(n).bind("touchmove mousemove", c),
				e(n).bind("touchend mouseup", d),
				7 > e.sceditor.ie && s.height(g),
				o.preventDefault()
			})
		},
		A = function() {
			var t, o = r.emoticons,
			i = r.emoticonsRoot;
			e.isPlainObject(o) && r.emoticonsEnabled && e.each(o,
			function(r, s) {
				e.each(s,
				function(e, s) {
					i && (s = {
						url: i + (s.url || s),
						tooltip: s.tooltip || e
					},
					o[r][e] = s),
					t = n.createElement("img"),
					t.src = s.url || s,
					st.push(t)
				})
			})
		},
		et = function() {
			var e, t, n, o = u[0],
			i = d[0],
			a = !!r.autofocusEnd;
			s.is(":visible") && (nt.sourceMode() ? (n = f.value.length, f.setSelectionRange ? f.setSelectionRange(n, n) : f.createTextRange && (e = f.createTextRange(), e.moveEnd("character", n), e.moveStart("character", n), b.selectRange(e))) : (a ? d.append(t = o.createElement("div")) : t = i.firstChild, o.createRange ? (e = o.createRange(), e.setStart(t, 0), e.setEnd(t, 0)) : (e = i.createTextRange(), e.moveToElementText(t), e.collapse(!1)), b.selectRange(e), a && (u.scrollTop(i.scrollHeight), d.scrollTop(i.scrollHeight))), nt.focus())
		},
		nt.readOnly = function(e) {
			return "boolean" != typeof e ? "readonly" === p.attr("readonly") : (d[0].contentEditable = !e, e ? p.attr("readonly", "readonly") : p.removeAttr("readonly"), Y(e), this)
		},
		nt.rtl = function(e) {
			var t = e ? "rtl": "ltr";
			return "boolean" != typeof e ? "rtl" === p.attr("dir") : (d.attr("dir", t), p.attr("dir", t), s.removeClass("rtl").removeClass("ltr").addClass(t), this)
		},
		Y = function(t) {
			var n = nt.inSourceMode();
			a.find(".sceditor-button").removeClass("disabled").each(function() {
				var o = e(this);
				t === !0 || n && !o.data("sceditor-txtmode") ? o.addClass("disabled") : n || o.data("sceditor-wysiwygmode") || o.addClass("disabled")
			})
		},
		nt.width = function(e, t) {
			return e || 0 === e ? (nt.dimensions(e, null, t), this) : s.width()
		},
		nt.dimensions = function(e, t, n) {
			return e = e || 0 === e ? e: !1,
			t = t || 0 === t ? t: !1,
			e === !1 && t === !1 ? {
				width: nt.width(),
				height: nt.height()
			}: (l.data("outerWidthOffset") === void 0 && nt.updateStyleCache(), e !== !1 && (n !== !1 && (r.width = e), e && ("" + e).indexOf("%") && (e = s.width(e).width()), l.width(e - l.data("outerWidthOffset")), p.width(e - p.data("outerWidthOffset")), t === !1 && (t = s.height(), n = !1)), t !== !1 && (n !== !1 && (r.height = t), t && ("" + t).indexOf("%") && (t = s.height(t).height(), s.height("auto")), t -= r.toolbarContainer ? 0 : a.outerHeight(!0), l.height(t - l.data("outerHeightOffset")), p.height(t - p.data("outerHeightOffset"))), this)
		},
		nt.updateStyleCache = function() {
			l.data("outerWidthOffset", l.outerWidth(!0) - l.width()),
			p.data("outerWidthOffset", p.outerWidth(!0) - p.width()),
			l.data("outerHeightOffset", l.outerHeight(!0) - l.height()),
			p.data("outerHeightOffset", p.outerHeight(!0) - p.height())
		},
		nt.height = function(e, t) {
			return e || 0 === e ? (nt.dimensions(null, e, t), this) : s.height()
		},
		nt.maximize = function(t) {
			return t === void 0 ? s.is(".sceditor-maximize") : (t = !!t, 7 > e.sceditor.ie && e("html, body").toggleClass("sceditor-maximize", t), s.toggleClass("sceditor-maximize", t), nt.width(t ? "100%": r.width, !1), nt.height(t ? "100%": r.height, !1), this)
		},
		nt.expandToContent = function(e) {
			var t = s.height(),
			n = d[0].scrollHeight || u[0].documentElement.scrollHeight,
			o = t - l.height(),
			i = r.resizeMaxHeight || 2 * (r.height || it.height());
			n += o,
			e !== !0 && n > i && (n = i),
			n > t && nt.height(n)
		},
		nt.destroy = function() {
			y.destroy(),
			b = null,
			m = null,
			y = null,
			e(n).unbind("click", Q),
			e(t).unbind("resize orientationChanged", U),
			e(ot.form).unbind("reset", q).unbind("submit", nt.updateOriginal),
			d.unbind(),
			u.unbind().find("*").remove(),
			p.unbind().remove(),
			s.unbind().find("*").unbind().remove(),
			s.remove(),
			it.removeData("sceditor").removeData("sceditorbbcode").show(),
			k && it.attr("required", "required")
		},
		nt.createDropDown = function(t, n, o, i) {
			var s = h && h.is(".sceditor-" + n);
			if (nt.closeDropDown(), !s) {
				i !== !1 && e(o).find(":not(input,textarea)").filter(function() {
					return 1 === this.nodeType
				}).attr("unselectable", "on");
				var a = {
					top: t.offset().top,
					left: t.offset().left,
					marginTop: t.outerHeight()
				};
				e.extend(a, r.dropDownCss),
				h = e('<div class="sceditor-dropdown sceditor-' + n + '" />').css(a).append(o).appendTo(e("body")).click(function(e) {
					e.stopPropagation()
				})
			}
		},
		Q = function(e) {
			3 !== e.which && nt.closeDropDown()
		},
		L = function(e) {
			function t(e, n) {
				if (e.childNodes.length > 0) {
					for (; e.firstChild;) n.appendChild(e.firstChild);
					for (; l.firstChild;) e.appendChild(l.firstChild);
					W(e, n)
				} else {
					if (s > 25) {
						for (; l.firstChild;) e.appendChild(l.firstChild);
						return b.restoreRange(),
						void 0
					}++s,
					setTimeout(function() {
						t(e, n)
					},
					20)
				}
			}
			var o, i = d[0],
			s = 0,
			a = i.ownerDocument.createElement("div"),
			l = i.ownerDocument.createDocumentFragment();
			if (r.disablePasting) return ! 1;
			if (r.enablePasteFiltering) {
				if (b.saveRange(), n.body.appendChild(a), e && e.clipboardData && e.clipboardData.getData && ((o = e.clipboardData.getData("text/html")) || (o = e.clipboardData.getData("text/plain")))) return a.innerHTML = o,
				W(i, a),
				e.stopPropagation(),
				e.preventDefault(),
				!1;
				for (; i.firstChild;) l.appendChild(i.firstChild);
				return t(i, a),
				nt.focus(),
				!0
			}
		},
		W = function(t, n) {
			e.sceditor.dom.fixNesting(n);
			var o = n.innerHTML;
			y.hasHandler("toSource") && (o = y.callOnlyFirst("toSource", o, e(n))),
			n.parentNode.removeChild(n),
			y.hasHandler("toWysiwyg") && (o = y.callOnlyFirst("toWysiwyg", o, !0)),
			b.restoreRange(),
			b.insertHTML(T(o))
		},
		nt.closeDropDown = function(e) {
			h && (h.unbind().remove(), h = null),
			e === !0 && nt.focus()
		},
		_ = function() {
			return c.contentDocument ? c.contentDocument: c.contentWindow && c.contentWindow.document ? c.contentWindow.document: c.document ? c.document: null
		},
		nt.wysiwygEditorInsertHtml = function(t, n, o) {
			nt.focus(),
			(o || !e(b.parentNode()).is("code") && 0 === e(b.parentNode()).parents("code").length) && (b.insertHTML(t, n), G())
		},
		nt.wysiwygEditorInsertText = function(t, n) {
			nt.wysiwygEditorInsertHtml(e.sceditor.escapeEntities(t), e.sceditor.escapeEntities(n))
		},
		nt.insertText = function(e, t) {
			return nt.inSourceMode() ? nt.sourceEditorInsertText(e, t) : nt.wysiwygEditorInsertText(e, t),
			this
		},
		nt.sourceEditorInsertText = function(e, t) {
			var o, i, r, s, a;
			a = f.scrollTop,
			f.focus(),
			f.selectionStart !== void 0 ? (i = f.selectionStart, r = f.selectionEnd, s = e.length, t && (e += f.value.substring(i, r) + t), f.value = f.value.substring(0, i) + e + f.value.substring(r, f.value.length), f.selectionStart = i + e.length - (t ? t.length: 0), f.selectionEnd = f.selectionStart) : n.selection.createRange !== void 0 ? (o = n.selection.createRange(), t && (e += o.text + t), o.text = e, t && o.moveEnd("character", 0 - t.length), o.moveStart("character", o.End - o.Start), o.select()) : f.value += e + t,
			f.scrollTop = a,
			f.focus()
		},
		nt.getRangeHelper = function() {
			return b
		},
		nt.val = function(e, t) {
			return "string" == typeof e ? (nt.inSourceMode() ? nt.setSourceEditorValue(e) : (t !== !1 && y.hasHandler("toWysiwyg") && (e = y.callOnlyFirst("toWysiwyg", e)), nt.setWysiwygEditorValue(e)), this) : nt.inSourceMode() ? nt.getSourceEditorValue(!1) : nt.getWysiwygEditorValue()
		},
		nt.insert = function(t, n, o, i, r) {
			if (nt.inSourceMode()) nt.sourceEditorInsertText(t, n);
			else {
				if (n) {
					var s = nt.getRangeHelper().selectedHtml(),
					a = e("<div>").appendTo(e("body")).hide().html(s);
					o !== !1 && y.hasHandler("toSource") && (s = y.callOnlyFirst("toSource", s, a)),
					a.remove(),
					t += s + n
				}
				o !== !1 && y.hasHandler("toWysiwyg") && (t = y.callOnlyFirst("toWysiwyg", t, !0)),
				o !== !1 && r === !0 && (t = t.replace(/&lt;/g, "<").replace(/&gt;/g, ">").replace(/&amp;/g, "&")),
				i !== !1 && (t = T(t)),
				nt.wysiwygEditorInsertHtml(t)
			}
			return this
		},
		nt.getWysiwygEditorValue = function(t) {
			var n;
			return e.sceditor.ie && nt.focus(),
			b.saveRange(),
			e.sceditor.dom.fixNesting(d[0]),
			n = d.html(),
			t !== !1 && y.hasHandler("toSource") && (n = y.callOnlyFirst("toSource", n, d)),
			b.restoreRange(),
			m = null,
			n
		},
		nt.getBody = function() {
			return d
		},
		nt.getContentAreaContainer = function() {
			return l
		},
		nt.getSourceEditorValue = function(e) {
			var t = p.val();
			return e !== !1 && y.hasHandler("toWysiwyg") && (t = y.callOnlyFirst("toWysiwyg", t)),
			t
		},
		nt.setWysiwygEditorValue = function(t) {
			t || (t = "<p>" + (e.sceditor.ie ? "": "<br />") + "</p>"),
			d[0].innerHTML = T(t),
			G()
		},
		nt.setSourceEditorValue = function(e) {
			p.val(e)
		},
		nt.updateOriginal = function() {
			it.val(nt.val())
		},
		T = function(t) {
			if (!r.emoticonsEnabled) return t;
			var n = e.extend({},
			r.emoticons.more, r.emoticons.dropdown, r.emoticons.hidden);
			return e.each(n,
			function(n, o) {
				var s = e.sceditor.regexEscape(n) + "(?=([^\\<\\>]*?<(?!/code)|[^\\<\\>]*?$))",
				a = "";
				r.emoticonsCompat && (s = "((>|^|\\s| | | | |&nbsp;))" + s + "(?=(\\s|$|<| | | | |&nbsp;))", a = "$1"),
				t = t.replace(RegExp(s, "gm"), a + i("emoticon", {
					key: n,
					url: o.url || o,
					tooltip: o.tooltip || n
				}))
			}),
			t
		},
		nt.inSourceMode = function() {
			return s.hasClass("sourceMode")
		},
		nt.sourceMode = function(e) {
			return "boolean" != typeof e ? nt.inSourceMode() : ((nt.inSourceMode() && !e || !nt.inSourceMode() && e) && nt.toggleSourceMode(), this)
		},
		nt.toggleSourceMode = function() { (e.sceditor.isWysiwygSupported || !nt.inSourceMode()) && (nt.inSourceMode() ? nt.setWysiwygEditorValue(nt.getSourceEditorValue()) : nt.setSourceEditorValue(nt.getWysiwygEditorValue()), m = null, p.toggle(), l.toggle(), nt.inSourceMode() ? s.removeClass("sourceMode").addClass("wysiwygMode") : s.removeClass("wysiwygMode").addClass("sourceMode"), Y(), K())
		},
		X = function() {
			return f.focus(),
			null != f.selectionStart ? f.value.substring(f.selectionStart, f.selectionEnd) : n.selection.createRange ? n.selection.createRange().text: void 0
		},
		D = function(t, n) {
			return nt.inSourceMode() ? (n.txtExec && (e.isArray(n.txtExec) ? nt.sourceEditorInsertText.apply(nt, n.txtExec) : n.txtExec.call(nt, t, X())), void 0) : (n.exec && (e.isFunction(n.exec) ? n.exec.call(nt, t) : nt.execCommand(n.exec, n.hasOwnProperty("execParam") ? n.execParam: null)), void 0)
		},
		M = function() {
			e.sceditor.ie && (m = b.selectedRange())
		},
		nt.execCommand = function(t, n) {
			var o = !1,
			i = e(b.parentNode());
			if (nt.focus(), !i.is("code") && 0 === i.parents("code").length) {
				try {
					o = u[0].execCommand(t, !1, n)
				} catch(r) {} ! o && nt.commands[t] && nt.commands[t].errorMessage && alert(nt._(nt.commands[t].errorMessage))
			}
		},
		J = function() {
			var t = function() {
				b && !b.compare(w) && (w = b.cloneSelected(), s.trigger(e.Event("selectionchanged"))),
				C = !1
			};
			C || (C = !0, e.sceditor.ie ? t() : setTimeout(t, 100))
		},
		Z = function() {
			var t = b.parentNode();
			x !== t && (s.trigger(e.Event("nodechanged", {
				oldNode: x,
				newNode: t
			})), x = t)
		},
		nt.currentNode = function() {
			return x
		},
		K = function(e) {
			var t, n, o, i, r, s = u[0],
			l = lt.length,
			c = nt.sourceMode();
			if (nt.sourceMode() || nt.readOnly()) a.find(".sceditor-button").removeClass("active");
			else for (r = e ? e.newNode: b.parentNode(), o = b.getFirstBlockParent(r); l--;) if (t = 0, n = lt[l], i = a.find(".sceditor-button-" + n.name), c && !i.data("sceditor-txtmode")) i.addClass("disabled");
			else if (c || i.data("sceditor-wysiwygmode")) {
				if ("string" == typeof n.state) try {
					t = s.queryCommandEnabled(n.state) ? 0 : -1,
					t > -1 && (t = s.queryCommandState(n.state) ? 1 : 0)
				} catch(d) {} else t = n.state.call(nt, r, o);
				0 > t ? i.addClass("disabled") : i.removeClass("disabled"),
				t > 0 ? i.addClass("active") : i.removeClass("active")
			} else i.addClass("disabled")
		},
		j = function(t) {
			var n, o = rt.length;
			if (nt.closeDropDown(), n = e(b.parentNode()), 13 === t.which && (n.is("code,blockquote,pre") || 0 !== n.parents("code,blockquote,pre").length)) return m = null,
			nt.wysiwygEditorInsertHtml("<br />", null, !0),
			!1;
			if (!n.is("code") && 0 === n.parents("code").length) for (; o--;) rt[o].call(nt, t, c, p)
		},
		G = function() {
			var t, n;
			e.sceditor.dom.rTraverse(d,
			function(o) {
				return t = o.nodeName.toLowerCase(),
				e.inArray(t, at) > -1 && (n = !0),
				3 === o.nodeType && !/^\s*$/.test(o.nodeValue) || "br" === o.nodeName.toLowerCase() || e.sceditor.ie && !o.firstChild && !e.sceditor.dom.isInline(o, !1) ? (n && e(d).append(e("<div>" + (e.sceditor.ie ? "": "<br />") + "</div>\n")), !1) : void 0
			})
		},
		q = function() {
			nt.val(it.val())
		},
		V = function() {
			nt.closeDropDown(),
			m = null
		},
		U = function() {
			var e = r.height,
			t = r.width;
			nt.maximize() ? nt.height("100%", !1).width("100%", !1) : (e && ("" + e).indexOf("%") > -1 && nt.height(e), t && ("" + t).indexOf("%") > -1 && nt.width(t))
		},
		nt._ = function() {
			var e = arguments;
			return g && g[e[0]] && (e[0] = g[e[0]]),
			e[0].replace(/\{(\d+)\}/g,
			function(t, n) {
				return e[n - 0 + 1] !== void 0 ? e[n - 0 + 1] : "{" + n + "}"
			})
		},
		$ = function(t) {
			var n, o = e.extend({},
			t);
			y.call(o.type + "Event", t, nt),
			delete o.type,
			n = e.Event((t.target === f ? "scesrc": "scewys") + t.type, o),
			s.trigger.apply(s, [n, nt]),
			n.isDefaultPrevented() && t.preventDefault(),
			n.isImmediatePropagationStopped() && n.stopImmediatePropagation(),
			n.isPropagationStopped() && n.stopPropagation()
		},
		nt.bind = function(t, n, o, i) {
			var r = t.length;
			for (t = t.split(" "); r--;) e.isFunction(n) && (o || s.bind("scewys" + t[r], n), i || s.bind("scesrc" + t[r], n));
			return this
		},
		nt.unbind = function(t, n, o, i) {
			var r = t.length;
			for (t = t.split(" "); r--;) e.isFunction(n) && (o || s.unbind("scewys" + t[r], n), i || s.unbind("scesrc" + t[r], n));
			return this
		},
		nt.blur = function(t, n, o) {
			return e.isFunction(t) ? nt.bind("blur", t, n, o) : nt.sourceMode() ? p.blur() : (v || (v = e('<input style="width:0;height:0;opacity:0;border:0;padding:0;filter:alpha(opacity=0)" type="text" />').appendTo(s)), v.removeAttr("disabled").show().focus().blur().hide().attr("disabled", "disabled")),
			this
		},
		nt.focus = function(t, n, o) {
			return e.isFunction(t) ? nt.bind("focus", t, n, o) : nt.inSourceMode() ? f.focus() : (c.contentWindow.focus(), d[0].focus(), m && (b.selectRange(m), m = null)),
			this
		},
		nt.keyDown = function(e, t, n) {
			return nt.bind("keydown", e, t, n)
		},
		nt.keyPress = function(e, t, n) {
			return nt.bind("keypress", e, t, n)
		},
		nt.keyUp = function(e, t, n) {
			return nt.bind("keyup", e, t, n)
		},
		nt.nodeChanged = function(e) {
			return nt.bind("nodechanged", e, !1, !0)
		},
		nt.selectionChanged = function(e) {
			return nt.bind("selectionchanged", e, !1, !0)
		},
		tt = function(t) {
			var n = 0,
			o = String.fromCharCode(t.which);
			return nt.emoticonsCache || (nt.emoticonsCache = [], e.each(e.extend({},
			r.emoticons.more, r.emoticons.dropdown, r.emoticons.hidden),
			function(e, t) {
				nt.emoticonsCache[n++] = [e, i("emoticon", {
					key: e,
					url: t.url || t,
					tooltip: t.tooltip || e
				})]
			}), nt.emoticonsCache.sort(function(e, t) {
				return e[0].length - t[0].length
			})),
			nt.longestEmoticonCode || (nt.longestEmoticonCode = nt.emoticonsCache[nt.emoticonsCache.length - 1][0].length),
			nt.getRangeHelper().raplaceKeyword(nt.emoticonsCache, !0, !0, nt.longestEmoticonCode, r.emoticonsCompat, o) ? /^\s$/.test(o) && r.emoticonsCompat ? !0 : (t.preventDefault(), t.stopPropagation(), !1) : void 0
		},
		nt.emoticons = function(t) {
			return t || t === !1 ? (r.emoticonsEnabled = t, t ? (d.keypress(tt), nt.sourceMode() || (b.saveRange(), d.html(T(d.html())), b.restoreRange())) : (d.find("img[data-sceditor-emoticon]").replaceWith(function() {
				return e(this).data("sceditor-emoticon")
			}), d.unbind("keypress", tt)), this) : r.emoticonsEnabled
		},
		nt.css = function(t) {
			return E || (E = e('<style id="#inline" />').appendTo(u.find("head"))[0]),
			"string" != typeof t ? E.styleSheet ? E.styleSheet.cssText: E.innerHTML: (E.styleSheet ? E.styleSheet.cssText = t: E.innerHTML = t, this)
		},
		F = function(e) {
			var t = [],
			n = {
				"`": "~",
				1 : "!",
				2 : "@",
				3 : "#",
				4 : "$",
				5 : "%",
				6 : "^",
				7 : "&",
				8 : "*",
				9 : "(",
				0 : ")",
				"-": "_",
				"=": "+",
				";": ":",
				"'": '"',
				",": "<",
				".": ">",
				"/": "?",
				"\\": "|",
				"[": "{",
				"]": "}"
			},
			o = {
				8 : "backspace",
				9 : "tab",
				13 : "enter",
				19 : "pause",
				20 : "capslock",
				27 : "esc",
				32 : "space",
				33 : "pageup",
				34 : "pagedown",
				35 : "end",
				36 : "home",
				37 : "left",
				38 : "up",
				39 : "right",
				40 : "down",
				45 : "insert",
				46 : "del",
				91 : "win",
				92 : "win",
				93 : "select",
				96 : "0",
				97 : "1",
				98 : "2",
				99 : "3",
				100 : "4",
				101 : "5",
				102 : "6",
				103 : "7",
				104 : "8",
				105 : "9",
				106 : "*",
				107 : "+",
				109 : "-",
				110 : ".",
				111 : "/",
				112 : "f1",
				113 : "f2",
				114 : "f3",
				115 : "f4",
				116 : "f5",
				117 : "f6",
				118 : "f7",
				119 : "f8",
				120 : "f9",
				121 : "f10",
				122 : "f11",
				123 : "f12",
				144 : "numlock",
				145 : "scrolllock",
				186 : ";",
				187 : "=",
				188 : ",",
				189 : "-",
				190 : ".",
				191 : "/",
				192 : "`",
				219 : "[",
				220 : "\\",
				221 : "]",
				222 : "'"
			},
			i = {
				109 : "-",
				110 : "del",
				111 : "/",
				96 : "0",
				97 : "1",
				98 : "2",
				99 : "3",
				100 : "4",
				101 : "5",
				102 : "6",
				103 : "7",
				104 : "8",
				105 : "9"
			},
			r = e.which,
			s = o[r] || String.fromCharCode(r).toLowerCase();
			return e.ctrlKey && t.push("ctrl"),
			e.altKey && t.push("alt"),
			e.shiftKey && (t.push("shift"), i[r] ? s = i[r] : n[s] && (s = n[s])),
			s && (16 > r || r > 18) && t.push(s),
			t = t.join("+"),
			ct[t] ? ct[t].call(nt) : void 0
		},
		nt.addShortcut = function(e, t) {
			return e = e.toLowerCase(),
			ct[e] = "string" == typeof t ?
			function() {
				return D(a.find(".sceditor-button-" + t), nt.commands[t]),
				!1
			}: t,
			this
		},
		nt.removeShortcut = function(e) {
			return delete ct[e.toLowerCase()],
			this
		},
		S()
	},
	e.sceditor.ie = function() {
		var e, o = 3,
		i = n.createElement("div"),
		r = i.getElementsByTagName("i");
		do i.innerHTML = "<!--[if gt IE " + ++o + "]><i></i><![endif]-->";
		while (r[0]);
		return n.all && t.atob && (o = 10),
		o > 4 ? o: e
	} (),
	e.sceditor.isWysiwygSupported = function() {
		var t, n = e('<div contenteditable="true">')[0].contentEditable,
		o = n !== void 0 && "inherit" !== n,
		i = navigator.userAgent;
		if (!o) return ! 1;
		var r = /Opera Mobi|Opera Mini/i.test(i);
		return /Android/i.test(i) && (r = !0, /Safari/.test(i) && (t = /Safari\/(\d+)/.exec(i), r = t && t[1] ? 534 > t[1] : !0)),
		/ Silk\//i.test(i) && (t = /AppleWebKit\/(\d+)/.exec(i), r = t && t[1] ? 534 > t[1] : !0),
		/iPhone|iPod|iPad/i.test(i) && (r = !/OS [5-9](_\d)+ like Mac OS X/i.test(i)),
		/fennec/i.test(i) && (r = !1),
		!r
	} (),
	e.sceditor.regexEscape = function(e) {
		return e.replace(/[\$\?\[\]\.\*\(\)\|\\]/g, "\\$&").replace("<", "&lt;").replace(">", "&gt;")
	},
	e.sceditor.escapeEntities = function(e) {
		return e ? e.replace(/&/g, "&amp;").replace(/</g, "&lt;").replace(/>/g, "&gt;").replace(/ {2}/g, " &nbsp;").replace(/\r\n|\r/g, "\n").replace(/\n/g, "<br />") : e
	},
	e.sceditor.locale = {},
	e.sceditor.commands = {
		bold: {
			exec: "bold",
			tooltip: "加粗",
			shortcut: "ctrl+b"
		},
		italic: {
			exec: "italic",
			tooltip: "斜体",
			shortcut: "ctrl+i"
		},
		underline: {
			exec: "underline",
			tooltip: "下划线",
			shortcut: "ctrl+u"
		},
		strike: {
			exec: "strikethrough",
			tooltip: "删除线"
		},
		subscript: {
			exec: "subscript",
			tooltip: "下标"
		},
		superscript: {
			exec: "superscript",
			tooltip: "上标"
		},
		left: {
			exec: "justifyleft",
			tooltip: "左对齐"
		},
		center: {
			exec: "justifycenter",
			tooltip: "居中"
		},
		right: {
			exec: "justifyright",
			tooltip: "右对齐"
		},
		justify: {
			exec: "justifyfull",
			tooltip: "整理"
		},
		font: {
			_dropDown: function(t, n, o) {
				for (var r = t.opts.fonts.split(","), s = e("<div />"), a = function() {
					return o(e(this).data("font")),
					t.closeDropDown(!0),
					!1
				},
				l = 0; r.length > l; l++) s.append(i("fontOpt", {
					font: r[l]
				},
				!0).click(a));
				t.createDropDown(n, "font-picker", s)
			},
			exec: function(t) {
				var n = this;
				e.sceditor.command.get("font")._dropDown(n, t,
				function(e) {
					n.execCommand("fontname", e)
				})
			},
			tooltip: "字体"
		},
		size: {
			_dropDown: function(t, n, o) {
				for (var r = e("<div />"), s = function(n) {
					o(e(this).data("size")),
					t.closeDropDown(!0),
					n.preventDefault()
				},
				a = 1; 7 >= a; a++) r.append(i("sizeOpt", {
					size: a
				},
				!0).click(s));
				t.createDropDown(n, "fontsize-picker", r)
			},
			exec: function(t) {
				var n = this;
				e.sceditor.command.get("size")._dropDown(n, t,
				function(e) {
					n.execCommand("fontsize", e)
				})
			},
			tooltip: "大小"
		},
		color: {
			_dropDown: function(t, n, o) {
				var i, r, s, a, l = {
					r: 255,
					g: 255,
					b: 255
				},
				c = e("<div />"),
				d = t.opts.colors ? t.opts.colors.split("|") : Array(21),
				u = [],
				p = e.sceditor.command.get("color");
				if (!p._htmlCache) {
					for (i = 0; d.length > i; ++i) {
						for (a = d[i] ? d[i].split(",") : Array(21), u.push('<div class="sceditor-color-column">'), r = 0; a.length > r; ++r) s = a[r] || "#" + l.r.toString(16) + l.g.toString(16) + l.b.toString(16),
						u.push('<a href="#" class="sceditor-color-option" style="background-color: ' + s + '" data-color="' + s + '"></a>'),
						0 === r % 5 ? (l.g -= 51, l.b = 255) : l.b -= 51;
						u.push("</div>"),
						0 === i % 5 ? (l.r -= 51, l.g = 255, l.b = 255) : (l.g = 255, l.b = 255)
					}
					p._htmlCache = u.join("")
				}
				c.append(p._htmlCache).find("a").click(function(n) {
					o(e(this).attr("data-color")),
					t.closeDropDown(!0),
					n.preventDefault()
				}),
				t.createDropDown(n, "color-picker", c)
			},
			exec: function(t) {
				var n = this;
				e.sceditor.command.get("color")._dropDown(n, t,
				function(e) {
					n.execCommand("forecolor", e)
				})
			},
			tooltip: "颜色"
		},
		removeformat: {
			exec: "removeformat",
			tooltip: "清除格式"
		},
		cut: {
			exec: "cut",
			tooltip: "剪切",
			errorMessage: "您的浏览器不支持剪切命令. 请使用ctrl+x"
		},
		copy: {
			exec: "copy",
			tooltip: "复制",
			errorMessage: "您的浏览器不支持复制命令. 请使用ctrl+c"
		},
		paste: {
			exec: "paste",
			tooltip: "复制",
			errorMessage: "您的浏览器不支持粘贴命令. 请使用ctrl+v"
		},
		pastetext: {
			exec: function(e) {
				var t, n = this,
				o = i("pastetext", {
					label: n._("Paste your text inside the following box:"),
					insert: n._("Insert")
				},
				!0);
				o.find(".button").click(function(e) {
					t = o.find("#txt").val(),
					t && n.wysiwygEditorInsertText(t),
					n.closeDropDown(!0),
					e.preventDefault()
				}),
				n.createDropDown(e, "pastetext", o)
			},
			tooltip: "复制段落"
		},
		bulletlist: {
			exec: "insertunorderedlist",
			tooltip: "点号列表"
		},
		orderedlist: {
			exec: "insertorderedlist",
			tooltip: "有序列表"
		},
		table: {
			exec: function(t) {
				var n = this,
				o = i("table", {
					rows: n._("Rows:"),
					cols: n._("Cols:"),
					insert: n._("Insert")
				},
				!0);
				o.find(".button").click(function(t) {
					var i = o.find("#rows").val() - 0,
					r = o.find("#cols").val() - 0,
					s = "<table>";
					if (! (1 > i || 1 > r)) {
						for (var a = 0; i > a; a++) {
							s += "<tr>";
							for (var l = 0; r > l; l++) s += "<td>" + (e.sceditor.ie ? "": "<br />") + "</td>";
							s += "</tr>"
						}
						s += "</table>",
						n.wysiwygEditorInsertHtml(s),
						n.closeDropDown(!0),
						t.preventDefault()
					}
				}),
				n.createDropDown(t, "inserttable", o)
			},
			tooltip: "插入表格"
		},
		horizontalrule: {
			exec: "inserthorizontalrule",
			tooltip: "标尺"
		},
		code: {
			forceNewLineAfter: ["code"],
			exec: function() {
				this.wysiwygEditorInsertHtml("<code>", "<br /></code>")
			},
			tooltip: "代码"
		},
		image: {
			exec: function(e) {
				var t = this,
				n = i("image", {
					url: t._("URL:"),
					width: t._("Width (optional):"),
					height: t._("Height (optional):"),
					insert: t._("Insert")
				},
				!0);
				n.find(".button").click(function(e) {
					var o = n.find("#image").val(),
					i = n.find("#width").val(),
					r = n.find("#height").val(),
					s = "";
					i && (s += ' width="' + i + '"'),
					r && (s += ' height="' + r + '"'),
					o && "http://" !== o && t.wysiwygEditorInsertHtml("<img" + s + ' src="' + o + '" />'),
					t.closeDropDown(!0),
					e.preventDefault()
				}),
				t.createDropDown(e, "insertimage", n)
			},
			tooltip: "插入图片"
		},
		email: {
			exec: function(e) {
				var t = this,
				n = i("email", {
					label: t._("E-mail:"),
					insert: t._("Insert")
				},
				!0);
				n.find(".button").click(function(e) {
					var o = n.find("#email").val();
					o && (t.focus(), t.getRangeHelper().selectedHtml() ? t.execCommand("createlink", "mailto:" + o) : t.wysiwygEditorInsertHtml('<a href="mailto:' + o + '">' + o + "</a>")),
					t.closeDropDown(!0),
					e.preventDefault()
				}),
				t.createDropDown(e, "insertemail", n)
			},
			tooltip: "插入邮件地址"
		},
		link: {
			exec: function(e) {
				var t = this,
				n = i("link", {
					url: t._("URL:"),
					desc: t._("Description (optional):"),
					ins: t._("Insert")
				},
				!0);
				n.find(".button").click(function(e) {
					var o = n.find("#link").val(),
					i = n.find("#des").val();
					o && "http://" !== o && (t.focus(), !t.getRangeHelper().selectedHtml() || i ? (i || (i = o), t.wysiwygEditorInsertHtml('<a href="' + o + '">' + i + "</a>")) : t.execCommand("createlink", o)),
					t.closeDropDown(!0),
					e.preventDefault()
				}),
				t.createDropDown(e, "insertlink", n)
			},
			tooltip: "插入链接"
		},
		unlink: {
			exec: "unlink",
			tooltip: "删除链接"
		},
		quote: {
			forceNewLineAfter: ["blockquote"],
			exec: function(e, t, n) {
				var o = "<blockquote>",
				i = "</blockquote>";
				t ? (n = n ? "<cite>" + n + "</cite>": "", o = o + n + t + i + "<br />", i = null) : "" === this.getRangeHelper().selectedHtml() && (i = "<br />" + i),
				this.wysiwygEditorInsertHtml(o, i)
			},
			tooltip: "引用"
		},
		emoticon: {
			exec: function(t) {
				var n = this,
				o = function(i) {
					var r = n.opts.emoticonsCompat ? " ": "",
					s = e("<div />"),
					a = e("<div />").appendTo(s),
					l = e.extend({},
					n.opts.emoticons.dropdown, i ? n.opts.emoticons.more: {}),
					c = 0;
					for (var d in l) l.hasOwnProperty(d) && c++;
					return c = Math.sqrt(c),
					e.each(l,
					function(t, o) {
						a.append(e("<img />").attr({
							src: o.url || o,
							alt: t,
							title: o.tooltip || t
						}).click(function() {
							return n.insert(e(this).attr("alt") + r).closeDropDown(!0),
							!1
						})),
						a.children().length >= c && (a = e("<div />").appendTo(s))
					}),
					i || s.append(e(n._('<a class="sceditor-more">{0}</a>', n._("More"))).click(function() {
						return n.createDropDown(t, "more-emoticons", o(!0)),
						!1
					})),
					s
				};
				n.createDropDown(t, "emoticons", o(!1))
			},
			txtExec: function(t) {
				e.sceditor.command.get("emoticon").exec.call(this, t)
			},
			tooltip: "表情"
		},
		youtube: {
			_dropDown: function(e, t, n) {
				var o, r = i("youtubeMenu", {
					label: e._("Video URL:"),
					insert: e._("Insert")
				},
				!0);
				r.find(".button").click(function(t) {
					var i = r.find("#link").val().replace("http://", "");
					"" !== i && (o = i.match(/(?:v=|v\/|embed\/|youtu.be\/)(.{11})/), o && (i = o[1]), /^[a-zA-Z0-9_\-]{11}$/.test(i) ? n(i) : alert("Invalid YouTube video")),
					e.closeDropDown(!0),
					t.preventDefault()
				}),
				e.createDropDown(t, "insertlink", r)
			},
			exec: function(t) {
				var n = this;
				e.sceditor.command.get("youtube")._dropDown(n, t,
				function(e) {
					n.wysiwygEditorInsertHtml(i("youtube", {
						id: e
					}))
				})
			},
			tooltip: "插入视频链接"
		},
		date: {
			_date: function(e) {
				var t = new Date,
				n = t.getYear(),
				o = t.getMonth() + 1,
				i = t.getDate();
				return 2e3 > n && (n = 1900 + n),
				10 > o && (o = "0" + o),
				10 > i && (i = "0" + i),
				e.opts.dateFormat.replace(/year/i, n).replace(/month/i, o).replace(/day/i, i)
			},
			exec: function() {
				this.insertText(e.sceditor.command.get("date")._date(this))
			},
			txtExec: function() {
				this.insertText(e.sceditor.command.get("date")._date(this))
			},
			tooltip: "插入当前日期"
		},
		time: {
			_time: function() {
				var e = new Date,
				t = e.getHours(),
				n = e.getMinutes(),
				o = e.getSeconds();
				return 10 > t && (t = "0" + t),
				10 > n && (n = "0" + n),
				10 > o && (o = "0" + o),
				t + ":" + n + ":" + o
			},
			exec: function() {
				this.insertText(e.sceditor.command.get("time")._time())
			},
			txtExec: function() {
				this.insertText(e.sceditor.command.get("time")._time())
			},
			tooltip: "插入当前时间"
		},
		ltr: {
			state: function(e, t) {
				return t && "ltr" === t.style.direction
			},
			exec: function() {
				var t = this,
				n = t.getRangeHelper().getFirstBlockParent(),
				o = e(n);
				t.focus(),
				(n && !o.is("body") || (t.execCommand("formatBlock", "p"), n = t.getRangeHelper().getFirstBlockParent(), o = e(n), n && !o.is("body"))) && ("ltr" === o.css("direction") ? o.css("direction", "") : o.css("direction", "ltr"))
			},
			tooltip: "左起"
		},
		rtl: {
			state: function(e, t) {
				return t && "rtl" === t.style.direction
			},
			exec: function() {
				var t = this,
				n = t.getRangeHelper().getFirstBlockParent(),
				o = e(n);
				t.focus(),
				(n && !o.is("body") || (t.execCommand("formatBlock", "p"), n = t.getRangeHelper().getFirstBlockParent(), o = e(n), n && !o.is("body"))) && ("rtl" === o.css("direction") ? o.css("direction", "") : o.css("direction", "rtl"))
			},
			tooltip: "右起"
		},
		print: {
			exec: "print",
			tooltip: "打印"
		},
		maximize: {
			state: function() {
				return this.maximize()
			},
			exec: function() {
				this.maximize(!this.maximize())
			},
			txtExec: function() {
				this.maximize(!this.maximize())
			},
			tooltip: "全屏",
			shortcut: "ctrl+shift+m"
		},
		source: {
			exec: function() {
				this.toggleSourceMode(),
				this.blur()
			},
			txtExec: function() {
				this.toggleSourceMode(),
				this.blur()
			},
			tooltip: "代码",
			shortcut: "ctrl+shift+s"
		},
		ignore: {}
	},
	e.sceditor.rangeHelper = function(t, n) {
		var o, i, r, s, a = !0,
		l = "sceditor-start-marker",
		c = "sceditor-end-marker",
		d = "character",
		u = this;
		r = function(e, t) {
			i = t || e.contentDocument || e.document,
			o = e,
			a = !!e.getSelection
		} (t, n),
		u.insertHTML = function(e, t) {
			var n, o, r = u.selectedRange();
			if (t && (e += u.selectedHtml() + t), a) {
				for (o = i.createElement("div"), n = i.createDocumentFragment(), o.innerHTML = e; o.firstChild;) n.appendChild(o.firstChild);
				u.insertNode(n)
			} else {
				if (!r) return ! 1;
				r.pasteHTML(e)
			}
		},
		u.insertNode = function(e, t) {
			if (a) {
				var n, o, r = i.createDocumentFragment(),
				s = u.selectedRange();
				if (!s) return ! 1;
				if (r.appendChild(e), t && (r.appendChild(s.extractContents()), r.appendChild(t)), o = r.lastChild, !o) return;
				s.deleteContents(),
				s.insertNode(r),
				n = i.createRange(),
				n.setStartAfter(o),
				u.selectRange(n)
			} else u.insertHTML(e.outerHTML, t ? t.outerHTML: null)
		},
		u.cloneSelected = function() {
			var e = u.selectedRange();
			return e ? a ? e.cloneRange() : e.duplicate() : void 0
		},
		u.selectedRange = function() {
			var e, t, n = a ? o.getSelection() : i.selection;
			if (n && (n.getRangeAt && 0 >= n.rangeCount && (e = i.createRange(), e.setStart(i.body, 0), n.addRange(e)), e = a ? n.getRangeAt(0) : n.createRange(), !e.parentElement || !(t = e.parentElement()) || t.ownerDocument === i)) return e
		},
		u.selectedHtml = function() {
			var e, t = u.selectedRange();
			return t ? !a && "" !== t.text && t.htmlText ? t.htmlText: a ? (e = i.createElement("div"), e.appendChild(t.cloneContents()), e.innerHTML) : "": ""
		},
		u.parentNode = function() {
			var e = u.selectedRange();
			if (e) {
				if (a) return e.commonAncestorContainer;
				if (e.parentElement) return e.parentElement()
			}
		},
		u.getFirstBlockParent = function(t) {
			var n = function(t) {
				if (!e.sceditor.dom.isInline(t)) return t;
				var o = t ? t.parentNode: null;
				return o ? n(o) : null
			};
			return n(t || u.parentNode())
		},
		u.insertNodeAt = function(e, t) {
			var n = u.selectedRange(),
			o = u.cloneSelected();
			return o ? (o.collapse(e), o.insertNode ? o.insertNode(t) : o.pasteHTML(t.outerHTML), u.selectRange(n), void 0) : !1
		},
		s = function(e) {
			u.removeMarker(e);
			var t = i.createElement("span");
			return t.id = e,
			t.style.lineHeight = "0",
			t.style.display = "none",
			t.className = "sceditor-selection sceditor-ignore",
			t
		},
		u.insertMarkers = function() {
			u.insertNodeAt(!0, s(l)),
			u.insertNodeAt(!1, s(c))
		},
		u.getMarker = function(e) {
			return i.getElementById(e)
		},
		u.removeMarker = function(e) {
			var t = u.getMarker(e);
			t && t.parentNode.removeChild(t)
		},
		u.removeMarkers = function() {
			u.removeMarker(l),
			u.removeMarker(c)
		},
		u.saveRange = function() {
			u.insertMarkers()
		},
		u.selectRange = function(e) {
			a ? (o.getSelection().removeAllRanges(), o.getSelection().addRange(e)) : e.select()
		},
		u.restoreRange = function() {
			var e, t = u.selectedRange(),
			n = u.getMarker(l),
			o = u.getMarker(c);
			return n && o && t ? (a ? (t = i.createRange(), t.setStartBefore(n), t.setEndAfter(o), u.selectRange(t)) : (t = i.body.createTextRange(), e = i.body.createTextRange(), e.moveToElementText(n), t.setEndPoint("StartToStart", e), t.moveStart(d, 0), e.moveToElementText(o), t.setEndPoint("EndToStart", e), t.moveEnd(d, 0), u.selectRange(t)), u.removeMarkers(), void 0) : !1
		},
		u.selectOuterText = function(e, t) {
			var n = u.cloneSelected();
			return n ? (n.collapse(!1), a ? (n.setStart(n.startContainer, n.startOffset - e), n.setEnd(n.endContainer, n.endOffset + t)) : (n.moveStart(d, 0 - e), n.moveEnd(d, t)), u.selectRange(n), void 0) : !1
		},
		u.getOuterText = function(e, t) {
			var n = "",
			o = u.cloneSelected();
			return o ? (o.collapse(!1), e ? a ? (n = o.startContainer.textContent.substr(0, o.startOffset), n = n.substr(Math.max(0, n.length - t))) : (o.moveStart(d, 0 - t), n = o.text) : a ? n = o.startContainer.textContent.substr(o.startOffset, t) : (o.moveEnd(d, t), n = o.text), n) : ""
		},
		u.raplaceKeyword = function(t, n, o, i, r, s) {
			o || t.sort(function(e, t) {
				return e.length - t.length
			});
			var l, c, d, p, f, h, m, g, b = i || t[t.length - 1][0].length;
			if (l = c = d = "", r) {
				if (!a) return ! 1; ++b
			}
			for (l = u.getOuterText(!0, b), n && (c = u.getOuterText(!1, b)), d = l + (null != s ? s: "") + c, p = t.length; p--;) if (m = RegExp("(?:[\\s    ])" + e.sceditor.regexEscape(t[p][0]) + "(?=[\\s    ])"), g = l.length - 1 - t[p][0].length, r && --g, g = Math.max(0, g), !r && (f = d.indexOf(t[p][0], g)) > -1 || r && (f = d.substr(g).search(m)) > -1) {
				if (r && (f += g + 1), f > l.length || f + t[p][0].length + (r ? 1 : 0) < l.length) continue;
				return h = l.length - f,
				u.selectOuterText(h, t[p][0].length - h - (null != s && /^\S/.test(s) ? 1 : 0)),
				u.insertHTML(t[p][1]),
				!0
			}
			return ! 1
		},
		u.compare = function(e, t) {
			return t || (t = u.selectedRange()),
			e && t ? a ? 0 === e.compareBoundaryPoints(Range.END_TO_END, t) && 0 === e.compareBoundaryPoints(Range.START_TO_START, t) : 0 === e.compareEndPoints("EndToEnd", t) && 0 === e.compareEndPoints("StartToStart", t) : !e && !t
		}
	},
	e.sceditor.dom = {
		traverse: function(e, t, n, o, i) {
			if (e) for (e = i ? e.lastChild: e.firstChild; null != e;) {
				var r = i ? e.previousSibling: e.nextSibling;
				if (!n && t(e) === !1) return ! 1;
				if (!o && this.traverse(e, t, n, o, i) === !1) return ! 1;
				if (n && t(e) === !1) return ! 1;
				e = r
			}
		},
		rTraverse: function(e, t, n, o) {
			this.traverse(e, t, n, o, !0)
		},
		blockLevelList: "|body|hr|p|div|h1|h2|h3|h4|h5|h6|address|pre|form|table|tbody|thead|tfoot|th|tr|td|li|ol|ul|blockquote|center|",
		isInline: function(t, n) {
			return t && 1 === t.nodeType ? (t = t.tagName.toLowerCase(), "code" === t ? !n: 0 > e.sceditor.dom.blockLevelList.indexOf("|" + t + "|")) : !0
		},
		copyCSS: function(e, t) {
			t.style.cssText = e.style.cssText + t.style.cssText
		},
		fixNesting: function(e) {
			var t = this,
			n = function(e) {
				for (; t.isInline(e.parentNode, !0);) e = e.parentNode;
				return e
			};
			t.traverse(e,
			function(e) {
				if (1 === e.nodeType && !t.isInline(e, !0) && t.isInline(e.parentNode, !0)) {
					var o = n(e),
					i = o.parentNode,
					r = t.extractContents(o, e),
					s = e;
					t.copyCSS(o, s),
					i.insertBefore(r, o),
					i.insertBefore(s, o)
				}
			})
		},
		findCommonAncestor: function(t, n) {
			return e(t).parents().has(e(n)).first()
		},
		getSibling: function(t, n) {
			var o;
			return t ? (o = t[n ? "previousSibling": "nextSibling"]) ? o: e.sceditor.dom.getSibling(t.parentNode, n) : null
		},
		removeWhiteSpace: function(t, n) {
			for (var o, i, r, s, a, l, c, d, u = e.sceditor.dom.getSibling,
			p = e.sceditor.dom.isInline,
			f = t.firstChild,
			h = /[\t ]+/g,
			m = /[\t\n\r ]+/g; f;) {
				if (l = f.nextSibling, o = f.nodeValue, i = f.nodeType, 1 === i && f.firstChild && (a = e(f).css("whiteSpace"), /pre(?:\-wrap)?$/i.test(a) || e.sceditor.dom.removeWhiteSpace(f, /line$/i.test(a))), 3 === i && o) {
					if (r = u(f), s = u(f, !0), d = f, c = !1, p(f)) for (; d = u(d, !0);) {
						for (; d.lastChild;) d = d.lastChild;
						if (!p(d) || 3 === d.nodeType) {
							c = 3 === d.nodeType ? /[\t\n\r ]$/.test(d.nodeValue) : !0;
							break
						}
					}
					p(f) && s && p(s) && !c || (o = o.replace(/^[\t\n\r ]+/, "")),
					p(f) && r && p(r) || (o = o.replace(/[\t\n\r ]+$/, "")),
					o.length ? f.nodeValue = o.replace(n ? h: m, " ") : t.removeChild(f)
				}
				f = l
			}
		},
		extractContents: function(e, t) {
			var n = this,
			o = n.findCommonAncestor(e, t),
			i = o ? o[0] : null,
			r = !1,
			s = !1;
			return function a(o) {
				var i = e.ownerDocument.createDocumentFragment();
				return n.traverse(o,
				function(n) {
					if (s || n === t && r) return s = !0,
					!1;
					n === e && (r = !0);
					var o, l;
					r ? jQuery.contains(n, t) && 1 === n.nodeType ? (o = a(n), l = n.cloneNode(!1), l.appendChild(o), i.appendChild(l)) : i.appendChild(n) : jQuery.contains(n, e) && 1 === n.nodeType && (o = a(n), l = n.cloneNode(!1), l.appendChild(o), i.appendChild(l))
				},
				!1),
				i
			} (i)
		}
	},
	e.sceditor.plugins = {},
	e.sceditor.PluginManager = function(t) {
		var n = this,
		o = [],
		i = t,
		r = function(e) {
			return "signal" + e.charAt(0).toUpperCase() + e.slice(1)
		},
		s = function(e, t) {
			e = [].slice.call(e);
			for (var n = o.length,
			s = r(e.shift()); n--;) if (s in o[n]) {
				if (t) return o[n][s].apply(i, e);
				o[n][s].apply(i, e)
			}
		};
		n.call = function() {
			s(arguments, !1)
		},
		n.callOnlyFirst = function() {
			return s(arguments, !0)
		},
		n.iter = function(e) {
			return e = r(e),
			function() {
				var t = o.length;
				return {
					callNext: function(n) {
						for (; t--;) if (o[t] && e in o[t]) return o[t].apply(i, n)
					},
					hasNext: function() {
						for (var n = t; n--;) if (o[n] && e in o[n]) return ! 0;
						return ! 1
					}
				}
			} ()
		},
		n.hasHandler = function(e) {
			var t = o.length;
			for (e = r(e); t--;) if (e in o[t]) return ! 0;
			return ! 1
		},
		n.exsists = function(t) {
			return t in e.sceditor.plugins ? (t = e.sceditor.plugins[t], "function" == typeof t && "object" == typeof t.prototype) : !1
		},
		n.isRegistered = function(t) {
			var i = o.length;
			if (!n.exsists(t)) return ! 1;
			for (; i--;) if (o[i] instanceof e.sceditor.plugins[t]) return ! 0;
			return ! 1
		},
		n.register = function(t) {
			return n.exsists(t) ? (t = new e.sceditor.plugins[t], o.push(t), "init" in t && t.init.apply(i), !0) : !1
		},
		n.deregister = function(t) {
			var r, s = o.length,
			a = !1;
			if (!n.isRegistered(t)) return ! 1;
			for (; s--;) o[s] instanceof e.sceditor.plugins[t] && (r = o.splice(s, 1)[0], a = !0, "destroy" in r && r.destroy.apply(i));
			return a
		},
		n.destroy = function() {
			for (var e = o.length; e--;)"destroy" in o[e] && o[e].destroy.apply(i);
			o = null,
			i = null
		}
	},
	e.sceditor.command = {
		get: function(t) {
			return e.sceditor.commands[t] || null
		},
		set: function(t, n) {
			return t && n ? (n = e.extend(e.sceditor.commands[t] || {},
			n), n.remove = function() {
				e.sceditor.command.remove(t)
			},
			e.sceditor.commands[t] = n, this) : !1
		},
		remove: function(t) {
			return e.sceditor.commands[t] && delete e.sceditor.commands[t],
			this
		}
	},
	e.sceditor.defaultOptions = {
		toolbar: "bold,italic,underline,strike,subscript,superscript|left,center,right,justify|font,size,color,removeformat|cut,copy,paste,pastetext|bulletlist,orderedlist|table|code,quote|horizontalrule,image,email,link,unlink|emoticon,youtube,date,time|ltr,rtl|print,maximize,source",
		toolbarExclude: null,
		style: "jquery.sceditor.default.css",
		fonts: "Arial,Arial Black,Comic Sans MS,Courier New,Georgia,Impact,Sans-serif,Serif,Times New Roman,Trebuchet MS,Verdana",
		colors: null,
		locale: "en",
		charset: "utf-8",
		emoticonsCompat: !1,
		emoticonsEnabled: !0,
		emoticonsRoot: "",
		emoticons: {
			dropdown: {
				":alien:": "resource/script/SCEditor/img/alien.png"
			},
			more: {
				":alien:": "resource/script/SCEditor/img/alien.png"
			},
			hidden: {
				":alien:": "resource/script/SCEditor/img/alien.png"
			}
		},
		width: null,
		height: null,
		resizeEnabled: !0,
		resizeMinWidth: null,
		resizeMinHeight: null,
		resizeMaxHeight: null,
		resizeMaxWidth: null,
		resizeHeight: !0,
		resizeWidth: !0,
		getHtmlHandler: null,
		getTextHandler: null,
		dateFormat: "year-month-day",
		toolbarContainer: null,
		enablePasteFiltering: !1,
		disablePasting: !1,
		readOnly: !1,
		rtl: !1,
		autofocus: !1,
		autofocusEnd: !0,
		autoExpand: !1,
		autoUpdate: !1,
		runWithoutWysiwygSupport: !1,
		id: null,
		plugins: "",
		zIndex: null,
		parserOptions: {},
		dropDownCss: {}
	},
	e.fn.sceditor = function(t) {
		var n, o = [];
		return t = t || {},
		t.runWithoutWysiwygSupport || e.sceditor.isWysiwygSupported ? (this.each(function() {
			n = this.jquery ? this: e(this),
			n.parents(".sceditor-container").length > 0 || ("state" === t ? o.push( !! n.data("sceditor")) : "instance" === t ? o.push(n.data("sceditor")) : n.data("sceditor") || new e.sceditor(this, t))
		}), o.length ? 1 === o.length ? o[0] : e(o) : this) : void 0
	}
})(jQuery, window, document),
/*!pl SCEditor | (C) 2011-2013, Sam Clarke | sceditor.com/license */
function(e, t, n) {
	"use strict";
	e.sceditor.BBCodeParser = function(t) {
		if (! (this instanceof e.sceditor.BBCodeParser)) return new e.sceditor.BBCodeParser(t);
		var o, i, r, s, a, l, c, d, u, p, f, h, m, g, b, v = this,
		y = {
			open: "open",
			content: "content",
			newline: "newline",
			close: "close"
		};
		Object.freeze && Object.freeze(y);
		var x = function(e, t, n, o, i, r) {
			var s = this;
			s.type = e,
			s.name = t,
			s.val = n,
			s.attrs = o || {},
			s.children = i || [],
			s.closing = r || null
		};
		x.prototype = {
			clone: function(e) {
				var t = this;
				return new x(t.type, t.name, t.val, t.attrs, e ? t.children: [], t.closing ? t.closing.clone() : null)
			},
			splitAt: function(t) {
				var n, o = this,
				i = 0,
				r = o.children.length;
				if ("number" != typeof object && (t = e.inArray(t, o.children)), 0 > t || t > r) return null;
				for (; r--;) r >= t ? i++:r = 0;
				return n = o.clone(),
				n.children = o.children.splice(t, i),
				n
			}
		},
		o = function() {
			v.opts = e.extend({},
			e.sceditor.BBCodeParser.defaults, t),
			v.bbcodes = e.sceditor.plugins.bbcode.bbcodes
		},
		v.tokenize = function(e) {
			var t, n, o, r = [],
			s = [{
				type: "close",
				regex: /^\[\/[^\[\]]+\]/
			},
			{
				type: "open",
				regex: /^\[[^\[\]]+\]/
			},
			{
				type: "newline",
				regex: /^(\r\n|\r|\n)/
			},
			{
				type: "content",
				regex: /^([^\[\r\n]+|\[)/
			}];
			s.reverse();
			e: for (; e.length;) {
				for (o = s.length; o--;) if (n = s[o].type, (t = e.match(s[o].regex)) && t[0]) {
					r.push(i(n, t[0])),
					e = e.substr(t[0].length);
					continue e
				}
				e.length && r.push(i(y.content, e)),
				e = ""
			}
			return r
		},
		i = function(t, n) {
			var o, i, s;
			return "open" === t && (o = n.match(/\[([^\]\s=]+)(?:([^\]]+))?\]/)) ? (s = g(o[1]), o[2] && (o[2] = e.trim(o[2])) && (i = r(o[2]))) : "close" === t && (o = n.match(/\[\/([^\[\]]+)\]/)) ? s = g(o[1]) : "newline" === t && (s = "#newline"),
			s && ("open" !== t && "close" !== t || e.sceditor.plugins.bbcode.bbcodes[s]) || (t = "content", s = "#"),
			new x(t, s, n, i)
		},
		r = function(t) {
			var n, o = /([^\s=]+)=(?:(?:(["'])((?:\\\2|[^\2])*?)\2)|((?:.(?!\s\S+=))*.))/g,
			i = e.sceditor.plugins.bbcode.stripQuotes,
			r = {};
			if ("=" === t.charAt(0) && 0 > t.indexOf("=", 1)) r.defaultattr = i(t.substr(1));
			else for ("=" === t.charAt(0) && (t = "defaultattr" + t); n = o.exec(t);) r[g(n[1])] = i(n[3]) || n[4];
			return r
		},
		v.parse = function(e, t) {
			var n = s(v.tokenize(e));
			return v.opts.fixInvalidChildren && u(n),
			v.opts.removeEmptyTags && d(n),
			v.opts.fixInvalidNesting && l(n),
			a(n, null, t),
			v.opts.removeEmptyTags && d(n),
			n
		},
		h = function(e, t, n) {
			for (var o = n.length; o--;) if (n[o].type === t && n[o].name === e) return ! 0;
			return ! 1
		},
		c = function(t, n) {
			var o = t ? v.bbcodes[t.name] : null,
			i = o ? o.allowedChildren: null;
			return v.opts.fixInvalidChildren && i ? i && 0 > e.inArray(n.name || "#", i) ? !1 : !0 : !0
		},
		s = function(t) {
			for (var n, o, i, r, s, a, l, c = [], d = [], u = [], p = function() {
				return b(u)
			},
			f = function(e) {
				p() ? p().children.push(e) : d.push(e)
			},
			m = function(t) {
				return p() && (o = v.bbcodes[p().name]) && o.closedBy && e.inArray(t, o.closedBy) > -1
			}; n = t.shift();) {
				switch (l = t[0], n.type) {
				case y.open:
					m(n.name) && u.pop(),
					f(n),
					o = v.bbcodes[n.name],
					o && o.isSelfClosing || !o.closedBy && !h(n.name, y.close, t) ? o && o.isSelfClosing || (n.type = y.content) : u.push(n);
					break;
				case y.close:
					if (p() && n.name !== p().name && m("/" + n.name) && u.pop(), p() && n.name === p().name) p().closing = n,
					u.pop();
					else if (h(n.name, y.open, u)) {
						for (; i = u.pop();) {
							if (i.name === n.name) {
								i.closing = n;
								break
							}
							r = i.clone(),
							c.length > 1 && r.children.push(b(c)),
							c.push(r)
						}
						for (f(b(c)), s = c.length; s--;) u.push(c[s]);
						c.length = 0
					} else n.type = y.content,
					f(n);
					break;
				case y.newline:
					p() && l && m((l.type === y.close ? "/": "") + l.name) && (l.type !== y.close || l.name !== p().name) && (o = v.bbcodes[p().name], o && o.breakAfter ? u.pop() : o && o.isInline === !1 && v.opts.breakAfterBlock && o.breakAfter !== !1 && u.pop()),
					f(n);
					break;
				default:
					f(n)
				}
				a = n
			}
			return d
		},
		a = function(e, t, n) {
			var o, i, r, s, l, c, d, u, p = e.length,
			f = p;
			for (t && (s = v.bbcodes[t.name]); f--;) if (o = e[f]) if (o.type === y.newline) {
				if (i = f > 0 ? e[f - 1] : null, r = p - 1 > f ? e[f + 1] : null, u = !1, !n && s && s.isSelfClosing !== !0 && (i ? c || r || (s.isInline === !1 && v.opts.breakEndBlock && s.breakEnd !== !1 && (u = !0), s.breakEnd && (u = !0), c = u) : (s.isInline === !1 && v.opts.breakStartBlock && s.breakStart !== !1 && (u = !0), s.breakStart && (u = !0))), i && i.type === y.open && (l = v.bbcodes[i.name]) && (n ? l.isInline === !1 && (u = !0) : (l.isInline === !1 && v.opts.breakAfterBlock && l.breakAfter !== !1 && (u = !0), l.breakAfter && (u = !0))), !n && !d && r && r.type === y.open && (l = v.bbcodes[r.name]) && (l.isInline === !1 && v.opts.breakBeforeBlock && l.breakBefore !== !1 && (u = !0), l.breakBefore && (u = !0), d = u, u)) {
					e.splice(f, 1);
					continue
				}
				u && e.splice(f, 1),
				d = !1
			} else o.type === y.open && a(o.children, o, n)
		},
		l = function(t, n, o, i) {
			var r, s, a, c, d, u, p = function(e) {
				var t = v.bbcodes[e.name];
				return ! t || t.isInline !== !1
			};
			for (n = n || [], i = i || t, s = 0; t.length > s; s++) if ((r = t[s]) && r.type === y.open) {
				if (!p(r) && o && (a = b(n), u = a.splitAt(r), d = n.length > 1 ? n[n.length - 2].children: i, (c = e.inArray(a, d)) > -1)) return u.children.splice(e.inArray(r, u.children), 1),
				d.splice(c + 1, 0, r, u),
				void 0;
				n.push(r),
				l(r.children, n, o || p(r), i),
				n.pop(r)
			}
		},
		u = function(e, t) {
			for (var n, o, i = e.length; i--;)(n = e[i]) && (c(t, n) || (n.name = null, n.type = y.content, c(t, n) ? (o = [i + 1, 0].concat(n.children), n.closing && (n.closing.name = null, n.closing.type = y.content, o.push(n.closing)), i += o.length - 1, Array.prototype.splice.apply(e, o)) : t.children.splice(i, 1)), n.type === y.open && u(n.children, n))
		},
		d = function(t) {
			var n, o, i, r = t.length;
			for (i = function(e) {
				for (var t = e.length; t--;) {
					if (e[t].type === y.open) return ! 1;
					if (e[t].type === y.close) return ! 1;
					if (e[t].type === y.content && e[t].val && /\S|\u00A0/.test(e[t].val)) return ! 1
				}
				return ! 0
			}; r--;)(n = t[r]) && n.type === y.open && (o = v.bbcodes[n.name], d(n.children), i(n.children) && o && !o.isSelfClosing && !o.allowsEmpty && t.splice.apply(t, e.merge([r, 1], n.children)))
		},
		v.toHTML = function(e, t) {
			return p(v.parse(e, t), !0)
		},
		p = function(t, o) {
			var i, r, s, a, l, c, d, u, f = [];
			for (d = function(e) {
				return (!e || (e.isHtmlInline !== void 0 ? e.isHtmlInline: e.isInline)) !== !1
			}; t.length > 0;) if (i = t.shift()) {
				if (i.type === y.open) u = i.children[i.children.length - 1] || {},
				r = v.bbcodes[i.name],
				l = o && d(r),
				s = p(i.children, !1),
				r && r.html ? (d(r) || !d(v.bbcodes[u.name]) || r.isPreFormatted || r.skipLastLineBreak || e.sceditor.ie || (s += "<br />"), a = e.isFunction(r.html) ? r.html.call(v, i, i.attrs, s) : e.sceditor.plugins.bbcode.formatString(r.html, s)) : a = i.val + s + (i.closing ? i.closing.val: "");
				else {
					if (i.type === y.newline) {
						if (!o) {
							f.push("<br />");
							continue
						}
						if (c) {
							f.push("</div>\n"),
							c = !1;
							continue
						}
						f.push("<div>"),
						e.sceditor.ie || f.push("<br />"),
						(n.documentMode && 8 > n.documentMode || 8 > e.sceditor.ie) && f.push(" "),
						f.push("</div>\n");
						continue
					}
					l = o,
					a = e.sceditor.escapeEntities(i.val)
				}
				l && !c ? (f.push("<div>"), c = !0) : !l && c && (f.push("</div>\n"), c = !1),
				f.push(a)
			}
			return c && f.push("</div>\n"),
			f.join("")
		},
		v.toBBCode = function(e, t) {
			return f(v.parse(e, t))
		},
		f = function(t) {
			for (var n, o, i, r, s, a, l, c, d, u, p = []; t.length > 0;) if (n = t.shift()) if (i = v.bbcodes[n.name], r = !(!i || i.isInline !== !1), s = i && i.isSelfClosing, l = r && v.opts.breakBeforeBlock && i.breakBefore !== !1 || i && i.breakBefore, c = r && !s && v.opts.breakStartBlock && i.breakStart !== !1 || i && i.breakStart, d = r && v.opts.breakEndBlock && i.breakEnd !== !1 || i && i.breakEnd, u = r && v.opts.breakAfterBlock && i.breakAfter !== !1 || i && i.breakAfter, a = (i ? i.quoteType: null) || v.opts.quoteType || e.sceditor.BBCodeParser.QuoteType.auto, i || n.type !== y.open) if (n.type === y.open) {
				if (l && p.push("\n"), p.push("[" + n.name), n.attrs) {
					n.attrs.defaultattr && (p.push("=" + m(n.attrs.defaultattr, a, "defaultattr")), delete n.attrs.defaultattr);
					for (o in n.attrs) n.attrs.hasOwnProperty(o) && p.push(" " + o + "=" + m(n.attrs[o], a, o))
				}
				p.push("]"),
				c && p.push("\n"),
				n.children && p.push(f(n.children)),
				s || i.excludeClosing || (d && p.push("\n"), p.push("[/" + n.name + "]")),
				u && p.push("\n"),
				n.closing && s && p.push(n.closing.val)
			} else p.push(n.val);
			else p.push(n.val),
			n.children && p.push(f(n.children)),
			n.closing && p.push(n.closing.val);
			return p.join("")
		},
		m = function(t, n, o) {
			var i = e.sceditor.BBCodeParser.QuoteType,
			r = /\s|=/.test(t);
			return e.isFunction(n) ? n(t, o) : n === i.never || n === i.auto && !r ? t: '"' + t.replace("\\", "\\\\").replace('"', '\\"') + '"'
		},
		b = function(e) {
			return e.length ? e[e.length - 1] : null
		},
		g = function(e) {
			return e.toLowerCase()
		},
		o()
	},
	e.sceditor.BBCodeParser.QuoteType = {
		always: 1,
		never: 2,
		auto: 3
	},
	Object.freeze && Object.freeze(e.sceditor.BBCodeParser.QuoteType),
	e.sceditor.BBCodeParser.defaults = {
		breakBeforeBlock: !1,
		breakStartBlock: !1,
		breakEndBlock: !1,
		breakAfterBlock: !0,
		removeEmptyTags: !0,
		fixInvalidNesting: !0,
		fixInvalidChildren: !0,
		quoteType: e.sceditor.BBCodeParser.QuoteType.auto
	},
	e.sceditorBBCodePlugin = e.sceditor.plugins.bbcode = function() {
		var t, o, i, r, s, a, l, c = this;
		r = e.sceditor.plugins.bbcode.formatString,
		c.bbcodes = e.sceditor.plugins.bbcode.bbcodes,
		c.stripQuotes = e.sceditor.plugins.bbcode.stripQuotes;
		var d = {},
		u = {},
		p = {
			ul: ["li", "ol", "ul"],
			ol: ["li", "ol", "ul"],
			table: ["tr"],
			tr: ["td", "th"],
			code: ["br", "p", "div"]
		},
		f = {};
		c.init = function() {
			c.opts = this.opts,
			t(),
			a(this),
			this.toBBCode = c.signalToSource,
			this.fromBBCode = c.signalToWysiwyg
		},
		a = function(t) {
			var n = {
				bold: {
					txtExec: ["[b]", "[/b]"]
				},
				italic: {
					txtExec: ["[i]", "[/i]"]
				},
				underline: {
					txtExec: ["[u]", "[/u]"]
				},
				strike: {
					txtExec: ["[s]", "[/s]"]
				},
				subscript: {
					txtExec: ["[sub]", "[/sub]"]
				},
				superscript: {
					txtExec: ["[sup]", "[/sup]"]
				},
				left: {
					txtExec: ["[left]", "[/left]"]
				},
				center: {
					txtExec: ["[center]", "[/center]"]
				},
				right: {
					txtExec: ["[right]", "[/right]"]
				},
				justify: {
					txtExec: ["[justify]", "[/justify]"]
				},
				font: {
					txtExec: function(t) {
						var n = this;
						e.sceditor.command.get("font")._dropDown(n, t,
						function(e) {
							n.insertText("[font=" + e + "]", "[/font]")
						})
					}
				},
				size: {
					txtExec: function(t) {
						var n = this;
						e.sceditor.command.get("size")._dropDown(n, t,
						function(e) {
							n.insertText("[size=" + e + "]", "[/size]")
						})
					}
				},
				color: {
					txtExec: function(t) {
						var n = this;
						e.sceditor.command.get("color")._dropDown(n, t,
						function(e) {
							n.insertText("[color=" + e + "]", "[/color]")
						})
					}
				},
				bulletlist: {
					txtExec: ["[ul][li]", "[/li][/ul]"]
				},
				orderedlist: {
					txtExec: ["[ol][li]", "[/li][/ol]"]
				},
				table: {
					txtExec: ["[table][tr][td]", "[/td][/tr][/table]"]
				},
				horizontalrule: {
					txtExec: ["[hr]"]
				},
				code: {
					txtExec: ["[code]", "[/code]"]
				},
				image: {
					txtExec: function(e, t) {
						var n = prompt(this._("Enter the image URL:"), t);
						n && this.insertText("[img]" + n + "[/img]")
					}
				},
				email: {
					txtExec: function(e, t) {
						var n = t && t.indexOf("@") > -1 ? null: t,
						o = prompt(this._("Enter the e-mail address:"), n ? "": t),
						i = prompt(this._("Enter the displayed text:"), n || o) || o;
						o && this.insertText("[email=" + o + "]" + i + "[/email]")
					}
				},
				link: {
					txtExec: function(e, t) {
						var n = t && t.indexOf("http://") > -1 ? null: t,
						o = prompt(this._("Enter URL:"), n ? "http://": t),
						i = prompt(this._("Enter the displayed text:"), n || o) || o;
						o && this.insertText("[url=" + o + "]" + i + "[/url]")
					}
				},
				quote: {
					txtExec: ["[quote]", "[/quote]"]
				},
				youtube: {
					txtExec: function(t) {
						var n = this;
						e.sceditor.command.get("youtube")._dropDown(n, t,
						function(e) {
							n.insertText("[youtube]" + e + "[/youtube]")
						})
					}
				},
				rtl: {
					txtExec: ["[rtl]", "[/rtl]"]
				},
				ltr: {
					txtExec: ["[ltr]", "[/ltr]"]
				}
			};
			t.commands = e.extend(!0, {},
			n, t.commands)
		},
		t = function() {
			e.each(c.bbcodes,
			function(t) {
				c.bbcodes[t].tags && e.each(c.bbcodes[t].tags,
				function(e, n) {
					var o = c.bbcodes[t].isInline === !1;
					d[e] = d[e] || {},
					d[e][o] = d[e][o] || {},
					d[e][o][t] = n
				}),
				c.bbcodes[t].styles && e.each(c.bbcodes[t].styles,
				function(e, n) {
					var o = c.bbcodes[t].isInline === !1;
					u[o] = u[o] || {},
					u[o][e] = u[o][e] || {},
					u[o][e][t] = n
				})
			})
		},
		s = function(t, n) {
			var o, i, r, s, a, l = t.style;
			return l ? (f[n] || (f[n] = e.camelCase(n)), a = f[n], "text-align" === n ? (o = e(t), r = l.direction, s = l[a] || o.css(n), o.parent().css(n) === s || "block" !== o.css("display") || o.is("hr") || o.is("th") || (i = s), r && i && (/right/i.test(i) && "rtl" === r || /left/i.test(i) && "ltr" === r) ? null: i) : l[a]) : null
		},
		o = function(t, n, o) {
			var i;
			return o = !!o,
			u[o] ? (e.each(u[o],
			function(o, a) {
				i = s(t[0], o),
				i && s(t.parent()[0], o) !== i && e.each(a,
				function(o, s) { (!s || e.inArray("" + i, s) > -1) && (n = e.isFunction(c.bbcodes[o].format) ? c.bbcodes[o].format.call(c, t, n) : r(c.bbcodes[o].format, n))
				})
			}), n) : n
		},
		i = function(t, n, o) {
			var i = t[0].nodeName.toLowerCase();
			if (o = !!o, d[i] && d[i][o] && e.each(d[i][o],
			function(o, i) {
				if (i) {
					var s = !1;
					if (e.each(i,
					function(n, o) {
						return ! t.attr(n) || o && 0 > e.inArray(t.attr(n), o) ? void 0 : (s = !0, !1)
					}), !s) return
				}
				n = e.isFunction(c.bbcodes[o].format) ? c.bbcodes[o].format.call(c, t, n) : r(c.bbcodes[o].format, n)
			}), o && (!e.sceditor.dom.isInline(t[0], !0) || "br" === i)) {
				for (var s = t[0].parentNode, a = t[0].previousSibling, l = e.sceditor.dom.isInline(s, !0) || "body" === s.nodeName.toLowerCase(); a && e(a).hasClass("sceditor-ignore");) a = a.previousSibling; (l || s.lastChild !== t[0] || "li" === i || "br" === i && e.sceditor.ie) && (n += "\n"),
				"br" !== i && a && "br" != a.nodeName.toLowerCase() && e.sceditor.dom.isInline(a, !0) && (n = "\n" + n)
			}
			return n
		},
		c.signalToSource = function(t, o) {
			var i, r, s = new e.sceditor.BBCodeParser(c.opts.parserOptions);
			return o || ("string" == typeof t ? (i = e("<div />").css("visibility", "hidden").appendTo(n.body).html(t), o = i) : o = e(t)),
			o && o.jquery ? (e.sceditor.dom.removeWhiteSpace(o[0]), r = c.elementToBbcode(o), i && i.remove(), e.trim(s.toBBCode(r, !0))) : ""
		},
		c.elementToBbcode = function(t) {
			return function n(t, r) {
				var s = "";
				return e.sceditor.dom.traverse(t,
				function(t) {
					var a = e(t),
					l = "",
					c = t.nodeType,
					d = t.nodeName.toLowerCase(),
					u = p[d],
					f = !0;
					if ("object" == typeof r && (f = e.inArray(d, r) > -1, f || (u = r)), 3 === c || 1 === c) if (1 === c) {
						if (a.hasClass("sceditor-ignore")) return;
						"iframe" !== d && (l = n(t, u)),
						f ? ("code" !== d && (l = o(a, l), l = i(a, l), l = o(a, l, !0)), s += i(a, l, !0)) : s += l
					} else ! t.wholeText || t.previousSibling && 3 === t.previousSibling.nodeType ? t.wholeText || (s += t.nodeValue) : s += 0 === a.parents("code").length ? t.wholeText.replace(/ +/g, " ") : t.wholeText
				},
				!1, !0),
				s
			} (t.get(0))
		},
		c.signalToWysiwyg = function(t, n) {
			var o = new e.sceditor.BBCodeParser(c.opts.parserOptions),
			i = o.toHTML(e.trim(t));
			return n ? l(i) : i
		},
		l = function(t) {
			var o, i, r, s = e("<div />").hide().appendTo(n.body),
			a = s[0];
			return r = function(t, o) {
				if (!t.className && !e(t).attr("style") && e.isEmptyObject(e(t).data())) {
					for (; i = t.firstChild;) a.insertBefore(i, t);
					if (o) {
						var r = a.lastChild;
						t !== r && e(r).is("div") && t.nextSibling === r && a.insertBefore(n.createElement("br"), t)
					}
					a.removeChild(t)
				}
			},
			a.innerHTML = t.replace(/<\/div>\n/g, "</div>"),
			(o = a.firstChild) && e(o).is("div") && r(o, !0),
			(o = a.lastChild) && e(o).is("div") && r(o),
			a = a.innerHTML,
			s.remove(),
			a
		}
	},
	e.sceditor.plugins.bbcode.stripQuotes = function(e) {
		return e ? e.replace(/\\(.)/g, "$1").replace(/^(["'])(.*?)\1$/, "$2") : e
	},
	e.sceditor.plugins.bbcode.formatString = function() {
		var e = arguments;
		return e[0].replace(/\{(\d+)\}/g,
		function(t, n) {
			return e[n - 0 + 1] !== void 0 ? e[n - 0 + 1] : "{" + n + "}"
		})
	},
	e.sceditor.plugins.bbcode.normaliseColour = function(e) {
		function t(e) {
			return e = parseInt(e, 10),
			isNaN(e) ? "00": (e = Math.max(0, Math.min(e, 255)).toString(16), 2 > e.length ? "0" + e: e)
		}
		var n;
		return (n = e.match(/rgb\((\d{1,3}),\s*?(\d{1,3}),\s*?(\d{1,3})\)/i)) ? "#" + t(n[1]) + t(n[2] - 0) + t(n[3] - 0) : (n = e.match(/#([0-f])([0-f])([0-f])\s*?$/i)) ? "#" + n[1] + n[1] + n[2] + n[2] + n[3] + n[3] : e
	},
	e.sceditor.plugins.bbcode.bbcodes = {
		b: {
			tags: {
				b: null,
				strong: null
			},
			styles: {
				"font-weight": ["bold", "bolder", "401", "700", "800", "900"]
			},
			format: "[b]{0}[/b]",
			html: "<strong>{0}</strong>"
		},
		i: {
			tags: {
				i: null,
				em: null
			},
			styles: {
				"font-style": ["italic", "oblique"]
			},
			format: "[i]{0}[/i]",
			html: "<em>{0}</em>"
		},
		u: {
			tags: {
				u: null
			},
			styles: {
				"text-decoration": ["underline"]
			},
			format: "[u]{0}[/u]",
			html: "<u>{0}</u>"
		},
		s: {
			tags: {
				s: null,
				strike: null
			},
			styles: {
				"text-decoration": ["line-through"]
			},
			format: "[s]{0}[/s]",
			html: "<s>{0}</s>"
		},
		sub: {
			tags: {
				sub: null
			},
			format: "[sub]{0}[/sub]",
			html: "<sub>{0}</sub>"
		},
		sup: {
			tags: {
				sup: null
			},
			format: "[sup]{0}[/sup]",
			html: "<sup>{0}</sup>"
		},
		font: {
			tags: {
				font: {
					face: null
				}
			},
			styles: {
				"font-family": null
			},
			quoteType: e.sceditor.BBCodeParser.QuoteType.never,
			format: function(e, t) {
				var n;
				return "font" === e[0].nodeName.toLowerCase() && (n = e.attr("face")) || (n = e.css("font-family")),
				"[font=" + this.stripQuotes(n) + "]" + t + "[/font]"
			},
			html: function(e, t, n) {
				return '<font face="' + t.defaultattr + '">' + n + "</font>"
			}
		},
		size: {
			tags: {
				font: {
					size: null
				}
			},
			styles: {
				"font-size": null
			},
			format: function(e, t) {
				var n = e.attr("size"),
				o = 1;
				return n || (n = e.css("fontSize")),
				n.indexOf("px") > -1 ? (n = n.replace("px", "") - 0, n > 12 && (o = 2), n > 15 && (o = 3), n > 17 && (o = 4), n > 23 && (o = 5), n > 31 && (o = 6), n > 47 && (o = 7)) : o = n,
				"[size=" + o + "]" + t + "[/size]"
			},
			html: function(e, t, n) {
				return '<font size="' + t.defaultattr + '">' + n + "</font>"
			}
		},
		color: {
			tags: {
				font: {
					color: null
				}
			},
			styles: {
				color: null
			},
			quoteType: e.sceditor.BBCodeParser.QuoteType.never,
			format: function(t, n) {
				var o, i = t[0];
				return "font" === i.nodeName.toLowerCase() && (o = t.attr("color")) || (o = i.style.color || t.css("color")),
				"[color=" + e.sceditor.plugins.bbcode.normaliseColour(o) + "]" + n + "[/color]"
			},
			html: function(e, t, n) {
				return '<font color="' + t.defaultattr + '">' + n + "</font>"
			}
		},
		ul: {
			tags: {
				ul: null
			},
			breakStart: !0,
			isInline: !1,
			skipLastLineBreak: !0,
			format: "[ul]{0}[/ul]",
			html: "<ul>{0}</ul>"
		},
		list: {
			breakStart: !0,
			isInline: !1,
			skipLastLineBreak: !0,
			html: "<ul>{0}</ul>"
		},
		ol: {
			tags: {
				ol: null
			},
			breakStart: !0,
			isInline: !1,
			skipLastLineBreak: !0,
			format: "[ol]{0}[/ol]",
			html: "<ol>{0}</ol>"
		},
		li: {
			tags: {
				li: null
			},
			isInline: !1,
			closedBy: ["/ul", "/ol", "/list", "*", "li"],
			format: "[li]{0}[/li]",
			html: "<li>{0}</li>"
		},
		"*": {
			isInline: !1,
			closedBy: ["/ul", "/ol", "/list", "*", "li"],
			html: "<li>{0}</li>"
		},
		table: {
			tags: {
				table: null
			},
			isInline: !1,
			isHtmlInline: !0,
			skipLastLineBreak: !0,
			format: "[table]{0}[/table]",
			html: "<table>{0}</table>"
		},
		tr: {
			tags: {
				tr: null
			},
			isInline: !1,
			skipLastLineBreak: !0,
			format: "[tr]{0}[/tr]",
			html: "<tr>{0}</tr>"
		},
		th: {
			tags: {
				th: null
			},
			allowsEmpty: !0,
			isInline: !1,
			format: "[th]{0}[/th]",
			html: "<th>{0}</th>"
		},
		td: {
			tags: {
				td: null
			},
			allowsEmpty: !0,
			isInline: !1,
			format: "[td]{0}[/td]",
			html: "<td>{0}</td>"
		},
		emoticon: {
			allowsEmpty: !0,
			tags: {
				img: {
					src: null,
					"data-sceditor-emoticon": null
				}
			},
			format: function(e, t) {
				return e.attr("data-sceditor-emoticon") + t
			},
			html: "{0}"
		},
		hr: {
			tags: {
				hr: null
			},
			allowsEmpty: !0,
			isSelfClosing: !0,
			isInline: !1,
			format: "[hr]{0}",
			html: "<hr />"
		},
		img: {
			allowsEmpty: !0,
			tags: {
				img: {
					src: null
				}
			},
			quoteType: e.sceditor.BBCodeParser.QuoteType.never,
			format: function(e, t) {
				var n, o, i = "",
				r = e[0],
				s = function(e) {
					return r.style ? r.style[e] : null
				};
				return e.attr("data-sceditor-emoticon") !== void 0 ? t: (n = e.attr("width") || s("width"), o = e.attr("height") || s("height"), (r.complete && (n || o) || n && o) && (i = "=" + e.width() + "x" + e.height()), "[img" + i + "]" + e.attr("src") + "[/img]")
			},
			html: function(e, t, n) {
				var o, i = "";
				return t.width !== void 0 && (i += ' width="' + t.width + '"'),
				t.height !== void 0 && (i += ' height="' + t.height + '"'),
				t.defaultattr && (o = t.defaultattr.split(/x/i), i = ' width="' + o[0] + '"' + ' height="' + (2 === o.length ? o[1] : o[0]) + '"'),
				"<img" + i + ' src="' + n + '" />'
			}
		},
		url: {
			allowsEmpty: !0,
			tags: {
				a: {
					href: null
				}
			},
			quoteType: e.sceditor.BBCodeParser.QuoteType.never,
			format: function(e, t) {
				var n = e.attr("href");
				return "mailto:" === n.substr(0, 7) ? '[email="' + n.substr(7) + '"]' + t + "[/email]": "[url=" + decodeURI(n) + "]" + t + "[/url]"
			},
			html: function(e, t, n) {
				return (t.defaultattr === void 0 || 0 === t.defaultattr.length) && (t.defaultattr = n),
				'<a href="' + encodeURI(t.defaultattr) + '">' + n + "</a>"
			}
		},
		email: {
			quoteType: e.sceditor.BBCodeParser.QuoteType.never,
			html: function(e, t, n) {
				return t.defaultattr === void 0 && (t.defaultattr = n),
				'<a href="mailto:' + t.defaultattr + '">' + n + "</a>"
			}
		},
		quote: {
			tags: {
				blockquote: null
			},
			isInline: !1,
			quoteType: e.sceditor.BBCodeParser.QuoteType.never,
			format: function(t, n) {
				var o = "",
				i = e(t),
				r = i.children("cite").first();
				return (1 === r.length || i.data("author")) && (o = r.text() || i.data("author"), i.data("author", o), r.remove(), i.children("cite").replaceWith(function() {
					return e(this).text()
				}), n = this.elementToBbcode(e(t)), o = "=" + o),
				"[quote" + o + "]" + n + "[/quote]"
			},
			html: function(e, t, n) {
				return t.defaultattr !== void 0 && (n = "<cite>" + t.defaultattr + "</cite>" + n),
				"<blockquote>" + n + "</blockquote>"
			}
		},
		code: {
			tags: {
				code: null
			},
			isInline: !1,
			allowedChildren: ["#", "#newline"],
			format: "[code]{0}[/code]",
			html: "<code>{0}</code>"
		},
		left: {
			styles: {
				"text-align": ["left", "-webkit-left", "-moz-left", "-khtml-left"]
			},
			isInline: !1,
			format: "[left]{0}[/left]",
			html: '<div align="left">{0}</div>'
		},
		center: {
			styles: {
				"text-align": ["center", "-webkit-center", "-moz-center", "-khtml-center"]
			},
			isInline: !1,
			format: "[center]{0}[/center]",
			html: '<div align="center">{0}</div>'
		},
		right: {
			styles: {
				"text-align": ["right", "-webkit-right", "-moz-right", "-khtml-right"]
			},
			isInline: !1,
			format: "[right]{0}[/right]",
			html: '<div align="right">{0}</div>'
		},
		justify: {
			styles: {
				"text-align": ["justify", "-webkit-justify", "-moz-justify", "-khtml-justify"]
			},
			isInline: !1,
			format: "[justify]{0}[/justify]",
			html: '<div align="justify">{0}</div>'
		},
		youtube: {
			allowsEmpty: !0,
			tags: {
				iframe: {
					"data-youtube-id": null
				}
			},
			format: function(e, t) {
				return (e = e.attr("data-youtube-id")) ? "[youtube]" + e + "[/youtube]": t
			},
			html: '<iframe width="560" height="315" src="http://www.youtube.com/embed/{0}?wmode=opaque" data-youtube-id="{0}" frameborder="0" allowfullscreen></iframe>'
		},
		rtl: {
			styles: {
				direction: ["rtl"]
			},
			format: "[rtl]{0}[/rtl]",
			html: '<div style="direction: rtl">{0}</div>'
		},
		ltr: {
			styles: {
				direction: ["ltr"]
			},
			format: "[ltr]{0}[/ltr]",
			html: '<div style="direction: ltr">{0}</div>'
		},
		ignore: {}
	},
	e.sceditor.plugins.bbcode.bbcode = {
		get: function(t) {
			return e.sceditor.plugins.bbcode.bbcodes[t] || null
		},
		set: function(t, n) {
			return t && n ? (n = e.extend(e.sceditor.plugins.bbcode.bbcodes[t] || {},
			n), n.remove = function() {
				e.sceditor.plugins.bbcode.bbcode.remove(t)
			},
			e.sceditor.plugins.bbcode.bbcodes[t] = n, this) : !1
		},
		rename: function(e, t) {
			return this.hasOwnProperty(e) ? (this[t] = this[e], this.remove(e), this) : !1
		},
		remove: function(t) {
			return e.sceditor.plugins.bbcode.bbcodes[t] && delete e.sceditor.plugins.bbcode.bbcodes[t],
			this
		}
	},
	e.fn.sceditorBBCodePlugin = function(t) {
		return t = t || {},
		e.isPlainObject(t) && (t.plugins = (t.plugins ? t.plugins: "") + "bbcode"),
		this.sceditor(t)
	}
} (jQuery, window, document);