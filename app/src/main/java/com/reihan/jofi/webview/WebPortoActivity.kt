package com.reihan.jofi.webview

import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.WebChromeClient
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.reihan.jofi.R
import com.reihan.jofi.databinding.ActivityWebPortoBinding

class WebPortoActivity : AppCompatActivity(), WebListener {

    private lateinit var binding: ActivityWebPortoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        binding = DataBindingUtil.setContentView(this, R.layout.activity_web_porto)

        binding.webViewContainer.loadUrl("https://github.com/reihanbay")

        binding.webViewContainer.webChromeClient = ChromeClient(this)
        binding.webViewContainer.webViewClient = WebPortoClient(this)
    }

    class ChromeClient(private val listener: WebListener) : WebChromeClient() {
        override fun onProgressChanged(view: WebView?, newProgress: Int) {
            listener.onProgressChange(newProgress)
            super.onProgressChanged(view, newProgress)
        }
    }

    class WebPortoClient(private val listener: WebListener): WebViewClient(){
        override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
            super.onPageStarted(view, url, favicon)
            listener.onPageStarted()
        }

        override fun onPageFinished(view: WebView?, url: String?) {
            super.onPageFinished(view, url)
            listener.onPageFinish()
        }

        override fun shouldOverrideUrlLoading(
            view: WebView?,
            url: String?
        ): Boolean {
            listener.onShouldOverrideUrl(url.orEmpty())
            return super.shouldOverrideUrlLoading(view, url)
        }

        override fun shouldOverrideUrlLoading(
            view: WebView?,
            request: WebResourceRequest?
        ): Boolean {
            listener.onShouldOverrideUrl(request?.url?.toString().orEmpty())
            return super.shouldOverrideUrlLoading(view, request)
        }
    }
    override fun onPageStarted() {
        binding.progressWebview.visibility = View.VISIBLE
        Toast.makeText(this, "PageStarted", Toast.LENGTH_SHORT).show()
    }

    override fun onPageFinish() {
        binding.progressWebview.visibility = View.GONE
    }

    override fun onShouldOverrideUrl(redirectUrl: String) {
        Toast.makeText(this, "redirect Url : $redirectUrl", Toast.LENGTH_SHORT).show()
    }

    override fun onProgressChange(progress: Int) {
        binding.progressWebview.progress = progress
    }
}